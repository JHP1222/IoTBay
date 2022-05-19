/**
 *
 * @author jaehyeon
 */
package uts.isd.controller;

import uts.isd.model.dao.DBManager;
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
import uts.isd.model.*;

public class ChangeQuantityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String action = request.getParameter("action");
        int productID = Integer.parseInt(request.getParameter("productID"));
        int orderID = Integer.parseInt(session.getAttribute("currentOrderID").toString());
        ArrayList<Cart> carts = (ArrayList<Cart>) request.getSession().getAttribute("currentCart");
        try {
            if (action != null && productID >= 1) {
                if (action.equals("inc")) {
                    for (Cart c : carts) {
                        if (c.getProductID() == productID) {
                            int quantity = c.getQuantity();
                            quantity++;
                            c.setQuantity(quantity);
                            manager.updateQuantity(orderID, productID, quantity + 1);
                            response.sendRedirect("CartPage.jsp");
                        }
                    }
                }

                if (action.equals("dec")) {
                    for (Cart c : carts) {
                        if (c.getProductID() == productID && c.getQuantity() > 1) {
                            int quantity = c.getQuantity();
                            quantity--;
                            c.setQuantity(quantity);
                            manager.updateQuantity(orderID, productID, quantity - 1);
                            break;
                        }
                    }
                    response.sendRedirect("CartPage.jsp");
                }
            } else {
                response.sendRedirect("CartPage.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangeQuantityServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
