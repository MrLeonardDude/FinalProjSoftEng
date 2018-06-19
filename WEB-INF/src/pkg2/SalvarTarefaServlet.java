package pkg2;

import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SalvarTarefaServlet extends HttpServlet {
    private static Sistema sist;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{ sist = Sistema.getInstance(); }catch(Exception excpt){ excpt.printStackTrace(); }
        String urlString = "http://localhost:8080/orkut/inicio.html";
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }

}