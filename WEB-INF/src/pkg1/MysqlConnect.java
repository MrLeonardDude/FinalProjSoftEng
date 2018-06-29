package pkg1;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MysqlConnect {
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Connection conn;


    public MysqlConnect() throws SQLException, ClassNotFoundException{
        connect();
    }

    private static void connect() throws SQLException, ClassNotFoundException{
        String user = "java";
        String password = "l^fV$?)}39^!o.P";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orkutBase?useSSL=true", user, password);
    }

    public ArrayList<String> sqlSelect(String querry, int n) throws SQLException{
        ArrayList<String> output = new ArrayList<String>();
        statement = conn.createStatement();
        resultSet= statement.executeQuery(querry);
        while(resultSet.next()){
            for (int i = 1; i <= n; i++) {
                output.add(resultSet.getString(i));
            }
        }
        return output;
    }

    public void sqlInsertCadastro(String querry, String username, String password, String funcao, String nome) throws SQLException{
        PreparedStatement preparedStmt2 = conn.prepareStatement(querry);
        preparedStmt2.setString(1, nome);
        preparedStmt2.setString(2, funcao);
        preparedStmt2.setString(3, username);
        preparedStmt2.setString(4, password);
        preparedStmt2.executeUpdate();
    }
    public void sqlInsertTarefa(String querry) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(querry);
    }
    public void sqlUpdate(String querry) throws SQLException{
        PreparedStatement preparedStmt = conn.prepareStatement(querry);
        preparedStmt.executeUpdate();
    }

    public int sqlUploadFile(String querry, String idTemp, String title, InputStream inputStream, Part filePart) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement(querry);
        preparedStatement.setString(1, idTemp);
        preparedStatement.setString(2, title);

        if (inputStream != null)
        {
            preparedStatement.setBinaryStream(3, inputStream, (int) filePart.getSize());
        }
        return preparedStatement.executeUpdate();
    }

    public static void disconnect() throws SQLException{
        conn.close();
    }

}