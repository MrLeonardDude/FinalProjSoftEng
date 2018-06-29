package pkg2;

import pkg1.MysqlConnect;
import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SalvarTarefaServlet extends HttpServlet {
    private static Sistema sist;
    private static MysqlConnect mysql;
    private static HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            sist = Sistema.getInstance();
            session = request.getSession();
        }catch(Exception excpt){ excpt.printStackTrace(); }
        String urlString ;
        String nomeTarefa = request.getParameter("nome_tarefa");
        String descricao = request.getParameter("descricao");
        String membros = '['+request.getParameter("membros")+']';
        response.setContentType("text/html; charset=UTF-8");
        Object Name = session.getAttribute("name");
        urlString = this.connectBD(Name.toString(), nomeTarefa, descricao, membros);
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }
    private String connectBD(String Name, String nomeTarefa, String descricao, String membros){
        String str = "http://localhost:8080/orkut/tarefas_"+Name+".html";
        try{
            mysql = sist.getMysql();
            String querry = "INSERT INTO tarefas (definicao, descricao, membros) values ('"+nomeTarefa+"', '"+descricao+"' , CAST('" + membros + "' as JSON))";
            mysql.sqlInsertTarefa(querry);
        }catch(Exception e){
            str = "http://localhost:8080/orkut/inicio.html";
        }
        return str;
    }

}
