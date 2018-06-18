package pkg1;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;

public class SessionManager implements HttpSessionListener{
    private Sistema sist;
    private MysqlConnect conn;
    private HttpSession currSesssion;
    private static Object usr = null;
    private static Object main = null;
    private static Object tar = null;
    private File file_main;
    private File file_tar;
    public void sessionCreated(HttpSessionEvent arg){

    }

    public void sessionDestroyed(HttpSessionEvent arg){
        try{
            /*sist = Sistema.getInstance();
            conn = sist.getMysql();
            currSesssion = arg.getSession();
            usr = currSesssion.getAttribute("username");
            main = currSesssion.getAttribute("urlMain");
            tar = currSesssion.getAttribute("Tarefas");
            file_main = new File(main.toString());
            file_tar = new File(tar.toString());
            file_main.delete();
            file_tar.delete();
            String querry2 = "UPDATE membros SET status=0 where username='"+usr+"'";
            conn.sqlUpdate(querry2);*/
        }catch(Exception excpt){
            excpt.printStackTrace();
        }
    }

}
