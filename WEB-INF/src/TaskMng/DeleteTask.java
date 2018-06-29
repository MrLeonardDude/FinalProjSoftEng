package TaskMng;

import SchedulerServlets.UserSpaceRebuild;
import pkg1.MysqlConnect;
import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteTask extends HttpServlet{

    private String id;
    private static Sistema sist;
    private static HttpSession session;
    private static MysqlConnect mysql;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{sist = Sistema.getInstance();}catch(Exception e){e.printStackTrace();        }
        mysql = sist.getMysql();
        String urlString = "http://localhost:8080/orkut/inicio.html";
        Object id = request.getParameter("ID");
        String sql = "delete from tarefas where ID=" + id.toString() ;
        try{mysql.sqlUpdate(sql);}catch(Exception e){e.printStackTrace();}
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request, response);
    }

}
