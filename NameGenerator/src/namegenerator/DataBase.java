
package namegenerator;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DataBase {
    
    String URLConnection;
    static String dataFromBase;
    String query;
    Connection connection;
    Statement stmt;
    ResultSet rs;
    
    public DataBase(String query){
        URLConnection = "jdbc:mysql://localhost:3306/name_generator";
        this.query = query;
        connection = null;

        try {
            connection = DriverManager.getConnection(URLConnection, "root", "");
            Class.forName("com.mysql.jdbc.Driver");
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
       
                        while (rs.next()) {
                                showDataFromBase(rs);
                        }
                        connection.close();
                }

                catch(ClassNotFoundException exception) {
                        System.out.println("Error driver!");
                }
 
                catch(SQLException exception) {
                    System.out.println("SQLException: " + exception.getMessage());
                    System.out.println("SQLState: " + exception.getSQLState());
                    System.out.println("VendorError: " + exception.getErrorCode());
                }
        
    }
 
        
        static void showDataFromBase(ResultSet rs){
                try{
                dataFromBase = rs.getString("name");
                System.out.println(dataFromBase);
                }catch(SQLException e) {
                        e.printStackTrace();
                }
        }
}
              