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
    
    public DataBase() throws SQLException, ClassNotFoundException{
        URLConnection = "jdbc:mysql://localhost:3306/name_generator";
        connection = null;     
        connection = DriverManager.getConnection(URLConnection, "root", "");
        Class.forName("com.mysql.jdbc.Driver");
        stmt = connection.createStatement();
    }
        
    public void getDataFromBase(String query){
        try {
            rs = stmt.executeQuery(query);
                        while (rs.next()) {
                                showDataFromBase(query);
                        }  
                } 
                catch(SQLException exception) {
                    System.out.println("SQLException: " + exception.getMessage());
                    System.out.println("SQLState: " + exception.getSQLState());
                    System.out.println("VendorError: " + exception.getErrorCode());
                } 
    }
            
         
    public void showDataFromBase(String query) throws SQLException{
        rs = stmt.executeQuery(query);
        while(rs.next()){
            dataFromBase = rs.getString("name");
            System.out.println(dataFromBase);
        }     
    }
    
    public void addToDataBase(String query) throws SQLException{
        PreparedStatement prepStatement;
        prepStatement = connection.prepareStatement(query);
    }
    
    public void closeConnection() throws SQLException{
        connection.close();
    }
}
              