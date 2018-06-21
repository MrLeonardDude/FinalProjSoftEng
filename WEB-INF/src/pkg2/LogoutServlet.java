package pkg2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    private static HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            session = request.getSession();
        }catch(Exception e){ e.printStackTrace();}
        String urlString = "http://localhost:8080/orkut/login.html";
        session.invalidate();
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }

}
