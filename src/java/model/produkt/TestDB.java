/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.produkt;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ksiezniczka
 */
public class TestDB implements Serializable
{
   
    
    public static void main(String args[]){
    Connection connection;
    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Product","joanna","joanna_1192432");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("Select * FROM JOANNA.SHOP");    
         
            while (results.next()) {
                int id=results.getInt("PRODUCTID");
                String name=results.getString("NAME");
                double cena=results.getDouble("PRICE");
                System.out.println(id+name+cena);
            }
        } catch(Exception e) {  
            e.printStackTrace();
        }  
    }     
    }
   
    
    
    
    
    
    
    /*{ 
        Connection connection;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","joanna_1192432");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM bookstore.book");    
         
            while (results.next()) {
                int isbn=results.getInt("ISBN");
                String name=results.getString("Title");
                String copy=results.getString("copyright");
                int enumber=results.getInt("editionNumber");
                int pubid=results.getInt("publisherID");
                double cena=results.getDouble("price");
                System.out.println(isbn+name+copy+enumber+pubid+cena);
            }
        } catch(Exception e) {  
            e.printStackTrace();
        }  
    } 
 }*/
