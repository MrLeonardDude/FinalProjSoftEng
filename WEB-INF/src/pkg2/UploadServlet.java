package pkg2;

import pkg1.MysqlConnect;
import pkg1.Sistema;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Random;

@MultipartConfig
public class UploadServlet extends HttpServlet{

    private static Sistema sist;
    private static MysqlConnect conn;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        Random rand = new Random();
        int  n = rand.nextInt(9999) + 1;
        String idTemp=(String.valueOf(n));
        String urlString = "http://localhost:8080/orkut/login.html";
        try{
            sist = Sistema.getInstance();
            conn = sist.getMysql();
            String sql = "INSERT INTO files (id, title, file) values (?, ?, ?)";
            int row = conn.sqlUploadFile(sql, idTemp, fileName, fileContent, filePart);
            if (row > 0) {

            }

        }catch(Exception e){e.printStackTrace();}
        response.sendRedirect(response.encodeRedirectURL(urlString));
    }
}
