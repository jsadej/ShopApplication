/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.produkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ksiezniczka
 */
public class Admin extends Produkt {

    static final String driver = "org.apache.derby.jdbc.ClientDriver";
    static final String URL_DB = "jdbc:derby://localhost:1527/Product";
    static final String user = "joanna";
    static final String pass = "joanna_1192432";
    Connection con = null;
    Statement st = null;

    public void UpdateListOfProdcut(String id, String name, String price) {
        int ID = Integer.parseInt(id);
        double d = Double.parseDouble(price);

        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_DB, user, pass);
            st = con.createStatement();

            String sgl = "UPDATE JOANNA.SHOP SET NAME_='" + name + "',PRICE=" + d + "WHERE PRODUCTID=" + ID;
            st.executeUpdate(sgl);
            con.close();
            st.close();
        } catch (SQLException s) {
            s.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

    } public void CalaulateDisciunts(String id, String name, String price, String Discounts) {
        int ID = Integer.parseInt(id);
        double discount = Double.parseDouble(Discounts);
        double Price = Double.parseDouble(price);
        Price = (Price * discount);
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_DB, user, pass);
            st = con.createStatement();

            String sgl = "UPDATE JOANNA.SHOP SET NAME_='" + name + "',PRICE=" + Price + "WHERE PRODUCTID=" + ID;
            st.executeUpdate(sgl);
            con.close();
            st.close();
        } catch (SQLException s) {
            s.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String args[]) {
      
        String name="Komputer";
        String price="1500";

        Admin ad = new Admin();
        ad.InsertNewProduct(name, price);
        Connection connection;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL_DB, user, pass);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("Select * FROM JOANNA.SHOP");

            while (results.next()) {
                int IDp = results.getInt("PRODUCTID");
                String NAME = results.getString("NAME_");
                double CENA = results.getDouble("PRICE");
                System.out.println(IDp + NAME + CENA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void DeleteListOfProdcut(String id) {
        int ID = Integer.parseInt(id);      
       
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_DB, user, pass);
            st = con.createStatement();

            String sgl ="DELETE FROM JOANNA.SHOP WHERE PRODUCTID = "+ID+" "; 
            st.executeUpdate(sgl);
            con.close();
            st.close();
        } catch (SQLException s) {
            s.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void InsertNewProduct(String name, String price) {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_DB, user, pass);
            String sql = "INSERT INTO JOANNA.SHOP( NAME_, PRICE)" + "VALUES ( ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, price);
            preparedStatement.executeUpdate();

          

            con.close();
            preparedStatement.close();
        } catch (SQLException s) {

            s.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
        
     
       


    