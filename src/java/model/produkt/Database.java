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
import java.sql.Statement;

/**
 *
 * @author Ksiezniczka
 */
public class Database implements Serializable {

    static final String driver = "org.apache.derby.jdbc.ClientDriver";//sterownik
    static final String URL_DB = "jdbc:derby://localhost:1527/Product";
    static final String user = "joanna";
    static final String pass = "joanna_1192432";
    private Connection connection;
    private Statement statement;
    ResultSet results;
    ResultSet Discountresults;

    public Database() {
    }

    public ResultSet getProductList() {

        try {
            Class.forName(driver);//załadowanie sterownika
            connection = DriverManager.getConnection(URL_DB, user, pass);
            statement = connection.createStatement();
            results = statement.executeQuery("Select * FROM JOANNA.SHOP");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;

    }
    public ResultSet getDiscountresults() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL_DB, user, pass);
            statement = connection.createStatement();
           Discountresults = statement.executeQuery("Select * FROM JOANNA.DISCOUNTS");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Discountresults;

    }
    
}
