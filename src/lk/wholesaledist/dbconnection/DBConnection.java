/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danu
 */
public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");  // translateor between java and sql --> create a Translate
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket?useSSL=false","root","25412541");
    } 
    public Connection getConnection(){
        return connection;
    } 
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection == null){
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
}
