/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.progra.resources.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joas2
 */
public class RelDatabase {
    Connection cnx;
    public RelDatabase(){
        cnx=this.getConnection();            
    }
    
    public Connection getConnection(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String server = "localhost";
            String port = "3306";
            String user = "root";
            String password = "root";
            String database = "SISTEMASEGUROAUTOMÓVILES";
            
            String URL_conexion="jdbc:mysql://"+ server+":"+port+"/"+database+"?user="+user+"&password="+
                    password+"&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(URL_conexion);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        } 
        return null;
    }
    
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }
    
    public int executeUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public ResultSet executeQuery(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
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
}
