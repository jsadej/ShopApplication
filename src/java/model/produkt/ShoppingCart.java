/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.produkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;




/**
 *
 * @author Ksiezniczka
 */
public class ShoppingCart extends Produkt {

    static final String driver = "org.apache.derby.jdbc.ClientDriver";
    static final String URL_DB = "jdbc:derby://localhost:1527/Product";
    static final String user = "joanna";
    static final String pass = "joanna_1192432";
    private Connection connection;
    private Statement statement;
    ResultSet Discountresults;

    Database db = new Database();
    HashMap<String, Produkt> listOfOrder;
    private double totalPrice = 0.0;

    public ShoppingCart() {
        listOfOrder = new HashMap<String, Produkt>();

    }

    public void DodajDoKoszyka(String produktID) {
        int productID = Integer.parseInt(produktID);
        db.getProductList();

        try {

            while (db.results.next()) {
                if (db.results.getInt("PRODUCTID") == productID) {
                    Produkt towar = new Produkt();
                    towar.setProductID(db.results.getInt("PRODUCTID"));
                    towar.setName(db.results.getString("NAME_"));
                    towar.setPrice(db.results.getDouble("PRICE"));
                    
                    listOfOrder.put(produktID, towar);
                    totalPrice += towar.getPrice();

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    public HashMap getItem() {
        return listOfOrder;
    }

    public void UsunZKoszyka(String produktID) {

        for (Iterator<Map.Entry<String, Produkt>> it = listOfOrder.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Produkt> entry = it.next();
            if (entry.getKey() == null ? produktID == null : entry.getKey().equals(produktID)) {
                it.remove();

                Produkt p = entry.getValue();

                totalPrice = totalPrice - p.getPrice();
            }
        }

    }

    public double getTotalPrice() {
        return totalPrice;
    }
   
}
    
    
