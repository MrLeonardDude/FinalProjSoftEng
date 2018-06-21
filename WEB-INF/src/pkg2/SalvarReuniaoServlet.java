package pkg2;

import pkg1.MysqlConnect;
import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SalvarReuniaoServlet extends HttpServlet {
    private static Sistema sist;
    private static HttpSession session;
    private static MysqlConnect mysql;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            sist = Sistema.getInstance();
            session = request.getSession();
        }catch(Exception excpt){ excpt.printStackTrace(); }
        String urlString;
        String nomeTarefa = request.getParameter("nome_tarefa");
        String dataTarefa = request.getParameter("data_tarefa");
        String descricao = request.getParameter("descricao");
        response.setContentType("text/html; charset=UTF-8");
        Object Name = session.getAttribute("name");
        urlString = this.connectBD(Name.toString(), nomeTarefa, descricao, dataTarefa);
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }

    private String connectBD(String Name, String nomeTarefa, String descricao, String dataTarefa){
        String str = "http://localhost:8080/orkut/reunioes.html";
        try{
            mysql = sist.getMysql();
            String querry = "INSERT INTO reuniao (data, local, pauta) values ('"+ dataTarefa +"', '"+nomeTarefa+"', '"+descricao+"' )";
            mysql.sqlInsertTarefa(querry);
        }catch(Exception e){
            str = "http://localhost:8080/orkut/inicio.html";
        }
        return str;
    }

}
