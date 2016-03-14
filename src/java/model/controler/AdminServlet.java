/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.produkt.Admin;
import model.produkt.Produkt;


/**
 *
 * @author Ksiezniczka
 */
public class AdminServlet extends HttpServlet {

    List<Produkt> listaproduktów = new ArrayList<Produkt>();
     List<Produkt> listofdiscount = new ArrayList<Produkt>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("produktID");
        String name = request.getParameter("nazwa");
        String price = request.getParameter("cena");
        String action = request.getParameter("action");
        String akcja = request.getParameter("akcja");
        String Discounts=request.getParameter("Discounts");
       
        Admin a = new Admin();

        if ("edition".equals(action)) {
           
            Produkt product = new Produkt();
            listofdiscount = product.returnDiscount();
            request.setAttribute("DISCOUNT", listofdiscount);
            request.setAttribute("ID", id);
            request.setAttribute("NAME", name);
            request.setAttribute("PRICE", price);
            RequestDispatcher view = request.getRequestDispatcher("formularz.jsp");
            view.forward(request, response);

        } else if ("delete".equals(action)) {
            a.DeleteListOfProdcut(id);
            Produkt p = new Produkt();
            listaproduktów = p.returnListaProduktow();
            request.setAttribute("Lista", listaproduktów);
            RequestDispatcher view = request.getRequestDispatcher("/admin.jsp");
            view.forward(request, response);
        } else if ("goToPanel".equals(action)) {
            Produkt p = new Produkt();
            listaproduktów = p.returnListaProduktow();
            listofdiscount = p.returnDiscount();
            request.setAttribute("DISCOUNT", listofdiscount);
            request.setAttribute("Lista", listaproduktów);
            RequestDispatcher view = request.getRequestDispatcher("/admin.jsp");
            view.forward(request, response);

        } else if ("dodaj".equals(akcja)) {

            String pattern2 = "[a-złąęćśóńżźA-Z ]+";
            String pattern3 = "\\d{1,3}(,?\\d{3})*(\\.\\d{1,2})?";

            Pattern PatternName = Pattern.compile(pattern2);
            Pattern PaternPrice = Pattern.compile(pattern3);

            Matcher mName = PatternName.matcher(name);
            Matcher mPrice = PaternPrice.matcher(price);
            if (mName.matches() && mPrice.matches()) {

                a.InsertNewProduct(name, price);
                Produkt p = new Produkt();
                listaproduktów = p.returnListaProduktow();
                request.setAttribute("Lista", listaproduktów);
                RequestDispatcher view = request.getRequestDispatcher("/admin.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("/errorPatern.jsp");
                view.forward(request, response);
            }
        } else {
            if ("BrakZnizki".equals(Discounts)) {
                a.UpdateListOfProdcut(id, name, price);

            } else {
                a.CalaulateDisciunts(id, name, price, Discounts);

            }
            Produkt p = new Produkt();
            listaproduktów = p.returnListaProduktow();
            request.setAttribute("Lista", listaproduktów);
            RequestDispatcher view = request.getRequestDispatcher("/admin.jsp");
            view.forward(request, response);

        }

    }
 //PrintWriter pw = response.getWriter();
  //pw.println("Disciunt: " + Discounts.toString());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         doGet(request,response);
        
        }

    
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
