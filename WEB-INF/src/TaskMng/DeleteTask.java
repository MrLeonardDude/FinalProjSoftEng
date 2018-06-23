package TaskMng;

import pkg1.MysqlConnect;
import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTask extends HttpServlet{

    private String id;
    private static Sistema sist;
    private static MysqlConnect mysql;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{sist = Sistema.getInstance();}catch(Exception e){e.printStackTrace();        }
        id = request.getParameter("id");
        mysql = sist.getMysql();
        String urlString = "http://localhost:8080/orkut/inicio.html";
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }

}
