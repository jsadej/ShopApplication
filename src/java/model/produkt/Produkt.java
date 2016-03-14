/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.produkt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ksiezniczka
 */
public class Produkt {

    private int ProductID;
    private String Name;
    private double Price;
    private double discountPrice;
    private int ID_disc;
    private String DiscountCode;

    public Produkt(int ProductID, String Name, double Price, double discountPrice,int ID_disc,String DiscountCode)
    {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Price = Price;
        this.discountPrice=discountPrice;
        this.ID_disc=ID_disc;
        this.DiscountCode=DiscountCode;
    }

    public Produkt() {
        ProductID = 0;
        Name = "";
        Price = 0;
        discountPrice = 0;
        ID_disc = 0;
        DiscountCode = "";
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getdiscountPrice() {
        return discountPrice;
    }

    public void setdiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getID_disc() {
        return ID_disc;
    }

    public void setID_disc(int ID_disc) {
        this.ID_disc = ID_disc;
    }

    public String getDiscountCode() {
        return DiscountCode;
    }

    public void setDiscountCode(String DiscountCode) {
        this.DiscountCode = DiscountCode;

    }

    public List<Produkt> returnListaProduktow() {
        Database rows = new Database();
        rows.getProductList();
        System.out.println("rows:" + rows);
        System.out.println("rows:" + rows.results.toString());

        List<Produkt> listaProduktow = new ArrayList();
        try {
            while (rows.results.next()) {
                Produkt rzecz = new Produkt();
                int id = rows.results.getInt("PRODUCTID");
                String name = rows.results.getString("NAME_");
                double cena = rows.results.getDouble("PRICE");
                int idDiscount=rows.results.getInt("ID_DISCOUNT");

                rzecz.setProductID(id);
                rzecz.setName(name);
                rzecz.setPrice(cena);
                rzecz.setID_disc(idDiscount);
                listaProduktow.add(rzecz);

            }

        } catch (SQLException e) {

            e.printStackTrace();

            System.out.println("SQLException :::" + e.getMessage());
        }

        return listaProduktow;
    }
    public List<Produkt> returnDiscount(){
    Database db=new Database();
    db.getDiscountresults();
    
        List<Produkt> discounts = new ArrayList();
        try {
            while (db.Discountresults.next()) {
                Produkt p = new Produkt();
                int id = db.Discountresults.getInt("ID_DISCOUNT");
                String code = db.Discountresults.getString("CODE");
                double discount = db.Discountresults.getDouble("DISCOUNT");

                p.setID_disc(id);
                p.setDiscountCode(code);
                p.setdiscountPrice(discount);
                discounts.add(p);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return discounts;

    }

   /* public static void main(String args[]) {
        Database db = new Database();
        db.getDiscountresults();

        try {
            while (db.Discountresults.next()) {
                int id = db.Discountresults.getInt("ID_DISCOUNT");
                String code = db.Discountresults.getString("CODE");
                double discount = db.Discountresults.getDouble("DISCOUNT");

                System.out.println(id + code + discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }*/
}
