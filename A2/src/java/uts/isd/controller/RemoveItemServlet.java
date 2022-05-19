package uts.isd.controller;

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
import uts.isd.model.Cart;
import uts.isd.model.dao.DBManager;

public class RemoveItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String productID = request.getParameter("productID");
        int orderID = Integer.parseInt(session.getAttribute("currentOrderID").toString());
        try {
            if (productID != null) {
                ArrayList<Cart> currentCart = (ArrayList<Cart>) request.getSession().getAttribute("currentCart");
                if (currentCart != null) {
                    for (Cart c : currentCart) {
                        if (c.getProductID() == Integer.parseInt(productID)) {
                            currentCart.remove(currentCart.indexOf(c));
                            manager.deleteCartItem(orderID, Integer.parseInt(productID));
                            response.sendRedirect("CartPage.jsp");
                            break;
                        }
                    }
                }

            } else {
                response.sendRedirect("Welcome.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RemoveItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
