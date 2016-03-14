/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.produkt.ShoppingCart;

/**
 *
 * @author Ksiezniczka
 */
public class KoszykServlet extends HttpServlet {
private double totalprice;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        HttpSession session = request.getSession();
        ShoppingCart cart;
        cart = (ShoppingCart) session.getAttribute("shopCart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("shopCart", cart);
            totalprice = 0.00;

        }
        String produktID = request.getParameter("produktID");
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            cart.DodajDoKoszyka(produktID);

        } else if ("delete".equals(action)) {
            cart.UsunZKoszyka(produktID);

        }
        HashMap<String, Object> listOfOrder = cart.getItem();
        totalprice = cart.getTotalPrice();
        request.setAttribute("price", totalprice);
        request.setAttribute("ListaKoszyk", listOfOrder);
        RequestDispatcher view = request.getRequestDispatcher("/koszyk.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
