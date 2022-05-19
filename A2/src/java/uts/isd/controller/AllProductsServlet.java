package uts.isd.controller;

import uts.isd.model.dao.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Product;

public class AllProductsServlet extends HttpServlet {

    private DBManager manager;
    private DBConnector Connector;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connector = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(AllProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            manager = new DBManager(Connector.openConnection());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AllProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //session
        HttpSession session = request.getSession();

        try {
            ArrayList<Product> inventory = manager.listProducts();
            if (inventory != null) {
                session.setAttribute("inventory", inventory);
                request.getRequestDispatcher("AllProducts.jsp").include(request, response);
                // session.setAttribute("show", "IoTBayInventory");
                // response.sendRedirect("AllProducts.jsp");
            } else {
                request.getRequestDispatcher("AllProducts.jsp").include(request, response);
                session.setAttribute("show", "Inventory does not exist");
                //response.sendRedirect("AllProducts.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}