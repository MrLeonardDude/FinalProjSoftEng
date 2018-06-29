package SchedulerServlets;

import pkg1.*;

import javax.lang.model.type.NullType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserSpaceRebuild implements Runnable{

    private static HttpSession session = null;
    private HTMLBuilder htmlBuild;
    private Sistema sist;
    private MysqlConnect mysql;
    private HTMLTarefasBuilder htmlTarBuild;
    private HTMLBuilderReuniao htmlReubuild;
    private String Name =null;
    private ServletContext context;
    private ArrayList<String> fileArray;


    public UserSpaceRebuild(ServletContext Le_context){
        context = Le_context;
    }

    private ArrayList<String> loadFiles() throws SQLException{
        ArrayList<String> files;
        String querry = "Select title from files";
        files = mysql.sqlSelect(querry, 1);
        return files;
    }

    private void loadTarefas()throws SQLException {
        String querry = "Select ID, definicao, descricao, progressoTotal, estado  from tarefas";
        ArrayList<String> str = mysql.sqlSelect(querry, 5);
        if(str.size() > 0){
            for(int i = 0; i < str.size(); i = i + 5) {
                Tarefa task = new Tarefa(Integer.valueOf(str.get(i)), str.get(i+1), str.get(i+2), Integer.valueOf(str.get(i+3)), str.get(i+4), null, null);
                sist.getSistTarefa().addTarefa(task);
            }

        }

        String querry1 = "Select ID, definicao, descricao, progressoTotal, estado from tarefas where progressoTotal < 100";
        ArrayList<String> str1 = mysql.sqlSelect(querry1, 5);
        if(str1.size() > 0){
            for(int i = 0; i < str1.size(); i = i + 5) {
                Tarefa task = new Tarefa(Integer.valueOf(str.get(i)), str.get(i+1), str.get(i+2), Integer.valueOf(str.get(i+3)), str.get(i+4), null, null);
                sist.getSistTarefa().addTarefaPendente(task);
            }

        }
    }

    private void loadMembros()throws SQLException {
        String querry = "Select nome,username,funcao from membros where status = 1 AND username <> '" + sist.getMembro().getUsername() + "'";
        ArrayList<String> str = mysql.sqlSelect(querry, 3);
        if(str.size() > 0){
            for(int i = 0; i < str.size(); i=i+3) {
                Membro m = new Membro(str.get(i),str.get(i+2),str.get(i+1),Boolean.TRUE);
                sist.getSistComunicacao().addMembroOnline(m);
            }
        }

        String querry2 = "Select nome,username,funcao from membros where status = 0";
        ArrayList<String> str2 = mysql.sqlSelect(querry2, 3);
        if(str2.size() > 0){
            for(int i = 0; i < str2.size(); i=i+3) {
                Membro m = new Membro(str2.get(i),str2.get(i+2),str2.get(i+1),Boolean.FALSE);
                sist.getSistComunicacao().addMembroOffline(m);
            }
        }

    }

    private void loadReunioes()throws SQLException {
        String querry = "Select ID,data,local,pauta from reuniao";
        ArrayList<String> str = mysql.sqlSelect(querry, 4);
        if(str.size() > 0){
            for(int i = 0; i < str.size(); i=i+4) {
                Reuniao r = new Reuniao(Integer.valueOf(str.get(i)),str.get(i+1),str.get(i+2),str.get(i+3));
                sist.getSistReuniao().addReuniao(r);
            }

        }
    }

    private Boolean rebuildHome(){
        int i =0;
        Boolean flag = Boolean.FALSE;
        try{
            mysql = sist.getMysql();
            String querry = "Select nome,username,funcao from membros where status = 1";
            ArrayList<String> str = mysql.sqlSelect(querry, 3);
            while(i < str.size()) {
                flag = Boolean.TRUE;
                Name = str.get(0);
                Membro usr = new Membro(str.get(0),str.get(2), str.get(1), Boolean.TRUE);
                sist.setMembro(usr);
                this.loadMembros();
                this.loadReunioes();
                this.loadTarefas();
                fileArray = loadFiles();
                htmlBuild = sist.getHtmlBuild();
                htmlTarBuild = sist.getHtmlTarefasBuilder();
                htmlReubuild = sist.getHtmlReuniaoBuilder();
                ArrayList<Tarefa> tar = sist.getSistTarefa().getTarefas();
                ArrayList<Membro> off =sist.getSistComunicacao().getMembrosOffline();
                ArrayList<Membro> on =sist.getSistComunicacao().getMembrosOnline();
                ArrayList<Tarefa> pend = sist.getSistTarefa().getTarefasPendents();
                ArrayList<Reuniao> reun = sist.getSistReuniao().getReunioes();
                htmlBuild.makeHome(on, off, pend, Name);
                htmlTarBuild.makeHome(tar, Name, fileArray);
                htmlReubuild.makeHome(reun, Name);
                sist.getSistComunicacao().setMembrosOffline(new ArrayList<Membro>());
                sist.getSistComunicacao().setMembrosOnline(new ArrayList<Membro>());
                sist.getSistTarefa().setTarefasPendente(new ArrayList<Tarefa>());
                sist.getSistTarefa().setTarefas(new ArrayList<Tarefa>());
                sist.getSistReuniao().setReunioes(new ArrayList<Reuniao>());
                i = i + 3;
            }
        }catch(Exception e){
            flag = Boolean.FALSE;
        }
        return flag;
    }

    @Override
    public void run(){
        try{ sist = Sistema.getInstance(); }catch(Exception excpt){ excpt.printStackTrace(); }
        rebuildHome();
    }
}
