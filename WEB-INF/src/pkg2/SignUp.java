package pkg2;

import pkg1.MysqlConnect;
import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends HttpServlet {

    private static MysqlConnect mysql;
    private static Sistema sist;


    private String connectBD(String username, String password, String funcao, String nome){
        String str = "http://localhost:8080/orkut/login.html";
        try{
            mysql = sist.getMysql();
            String querry = "INSERT INTO membros (nome, funcao, username, password) values (?, ?, ?, ?)";
            mysql.sqlInsertCadastro(querry, username, password, funcao, nome);
        }catch(Exception e){
            if(username.length() > 15)
                str = "http://localhost:8080/orkut/cadastro_username.html";
            else if(password.length() > 15)
                str = "http://localhost:8080/orkut/cadastro_password.html";
            else if(funcao.length() > 15)
                str = "http://localhost:8080/orkut/cadastro_funcao.html";
            else if(nome.length() > 50)
                str = "http://localhost:8080/orkut/cadastro_nome.html";
            else
                str = "http://localhost:8080/orkut/cadastro.html";
        }
        return str;
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        try{ sist = Sistema.getInstance(); }catch(Exception excpt){ excpt.printStackTrace(); }
        String username = request.getParameter("username");
        String psswrd = request.getParameter("password");
        String funcao = request.getParameter("funcao");
        String nome = request.getParameter("nome");
        String urlString = this.connectBD(username, psswrd, funcao, nome);
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }

}
