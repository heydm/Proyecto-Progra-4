/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.progra.resources.data; 
import java.sql.Connection;
import java.sql.DriverManager;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
 
    Connection cnx;
    public DBConnection(){
        cnx=this.createConnection();            
    }
    
    public static Connection createConnection()
    {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/customers";
    String username = "root";
    String password = "root123";
 
    try
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Post establishing a DB connection - "+con);
    }
    catch (SQLException e)
        {
           System.out.println("An error occurred. Maybe user/password is invalid");
         e.printStackTrace();
       }
    return con;
    }
    
    public int executeUpdateWithKeys(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stm.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }
    
    public ResultSet executeQuery(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }
}