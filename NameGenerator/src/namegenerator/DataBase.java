package namegenerator;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DataBase {
    
    private String URLConnection;
    private static String dataFromBase;
    private static Connection connection;
    private static Statement stmt;
    private ResultSet rs;
    
    public DataBase() throws SQLException, ClassNotFoundException{
        URLConnection = "jdbc:mysql://localhost:3306/name_generator";
        connection = null;     
        connection = DriverManager.getConnection(URLConnection, "root", "");
        Class.forName("com.mysql.jdbc.Driver");
        stmt = connection.createStatement();
    }
         
    public void showDataFromBase(String query) throws SQLException{
        rs = stmt.executeQuery(query);
        while(rs.next()){
            dataFromBase = rs.getString("name");
            System.out.println(dataFromBase);
        }     
    }
    
    public static void addToDataBase(String name, int sex) throws SQLException {
        System.out.println(sex);
        stmt.executeUpdate("INSERT INTO `names` (`id`, `name`, `sex`) VALUES (NULL, '" + name + "' , '" + sex + "')");
    }
    
    public void closeConnection() throws SQLException{
        connection.close();
    }
}