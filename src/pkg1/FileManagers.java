package pkg1;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;


class FilesManager extends HttpServlet {

    private Sistema sist = null;
    private MysqlConnect conn = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        InputStream inputStream = null;

        Random rand = new Random();
        int  n = rand.nextInt(9999) + 1;
        String idTemp=(String.valueOf(n));


        String title=(request.getParameter("title"));
        Part filePart = request.getPart("file_uploaded");

        if (filePart != null)
        {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
        }

        try
        {

            sist = Sistema.getInstance();
            conn = sist.getMysql();
            String sql = "INSERT INTO files (id, title, file) values (?, ?, ?)";
            int row = conn.sqlUploadFile(sql, idTemp, title, inputStream, filePart);
            if (row > 0)
            {
                out.println("File uploaded!!!");
                RequestDispatcher rs = request.getRequestDispatcher("upload_form.jsp");
                rs.include(request, response);
            }
            else
            {
                out.println("Couldn't upload your file!!!");

                RequestDispatcher rs = request.getRequestDispatcher("upload_form.jsp");
                rs.include(request, response);
            }

        }catch(Exception e){e.printStackTrace();}
    }
}