package pkg1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pkg1main extends HttpServlet{

    private static final long serialVersionUID = 178932193873712398L;
    private static HttpSession session = null;
    private HTMLBuilder htmlBuild;
    private Sistema sist;
    private MysqlConnect mysql;
    private HTMLTarefasBuilder htmlTarBuild;
    private HTMLBuilderReuniao htmlReubuild;
    private String Name =null;

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

    private Boolean connectBD(String username, String password){
        Boolean flag = Boolean.FALSE;
        try{
            mysql = sist.getMysql();
            String querry = "Select nome,username,funcao from membros where username ='"+username+"' AND password='"+password+"'";
            ArrayList<String> str = mysql.sqlSelect(querry, 3);
            if(str.size() > 0) {
                flag = Boolean.TRUE;
                Name = str.get(0);
                Membro usr = new Membro(str.get(0),str.get(2), str.get(1), Boolean.TRUE);
                sist.setMembro(usr);
                this.loadReunioes();
                this.loadTarefas();
                String querry2 = "UPDATE membros SET status=1 where username='"+ username+ "'";
                mysql.sqlUpdate(querry2);
                this.loadMembros();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html; charset=UTF-8");
        try{ sist = Sistema.getInstance(); }catch(Exception excpt){ excpt.printStackTrace(); }

        String username = request.getParameter("username");
        String psswrd = request.getParameter("password");

        String urlString = "http://localhost:8080/orkut/login.html";
        if(this.connectBD(username, psswrd)) {
            htmlBuild = sist.getHtmlBuild();
            htmlTarBuild = sist.getHtmlTarefasBuilder();
            htmlReubuild = sist.getHtmlReuniaoBuilder();
            session = request.getSession();
            session.setMaxInactiveInterval(5*60);
            session.setAttribute("username", username);
            session.setAttribute("name", Name);
            urlString = "http://localhost:8080/orkut/orkut_"+Name+".html";
            session.setAttribute("urlMain", "/opt/tomcat/webapps/orkut/orkut_"+Name+".html");
            session.setAttribute("Tarefas", "/opt/tomcat/webapps/orkut/tarefas_"+Name+".html");
            session.setAttribute("Reuniao" , "/opt/tomcat/webapps/orkut/reunioes_"+Name+".html");
            session.setAttribute("main", urlString);
            ArrayList<Tarefa> tar = sist.getSistTarefa().getTarefas();
            ArrayList<Membro> off =sist.getSistComunicacao().getMembrosOffline();
            ArrayList<Membro> on =sist.getSistComunicacao().getMembrosOnline();
            ArrayList<Tarefa> pend = sist.getSistTarefa().getTarefasPendents();
            ArrayList<Reuniao> reun = sist.getSistReuniao().getReunioes();
            htmlBuild.makeHome(on, off, pend, Name);
            htmlTarBuild.makeHome(tar, Name);
            htmlReubuild.makeHome(reun, Name);
            sist.getSistComunicacao().setMembrosOffline(new ArrayList<Membro>());
            sist.getSistComunicacao().setMembrosOnline(new ArrayList<Membro>());
            sist.getSistTarefa().setTarefasPendente(new ArrayList<Tarefa>());
            sist.getSistTarefa().setTarefas(new ArrayList<Tarefa>());
            sist.getSistReuniao().setReunioes(new ArrayList<Reuniao>());
        }
        response.sendRedirect(response.encodeRedirectURL(urlString));

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
