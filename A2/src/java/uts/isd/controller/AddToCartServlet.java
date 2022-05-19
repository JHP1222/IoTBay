package uts.isd.controller;

/**
 *
 * @author jaehyeon
 */
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

public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int productID = Integer.parseInt(session.getAttribute("currentProductID").toString());
        double price = Double.parseDouble(session.getAttribute("currentProductPrice").toString());
        String productName = session.getAttribute("currentProductName").toString();
        Product currentProduct = (Product) session.getAttribute("orderedProduct");
        int orderID = Integer.parseInt(session.getAttribute("currentOrderID").toString());
        int quantity = currentProduct.getProductQuantity();
        double productPrice = currentProduct.getProductPrice();
        if (session.getAttribute("currentCustomerID") != null) {
            try {
                Cart itemToCheck = manager.fetchCartItem(orderID, productID);
                if (itemToCheck == null) {
                    int customerID = Integer.parseInt(session.getAttribute("currentCustomerID").toString());
                    if (customerID != 0) {

                        Cart cart = new Cart(orderID, productID, productName, quantity, productPrice);
                        int cartID = cart.getCartID();
                        manager.addCartItem(cartID, orderID, productID, productName, 1, price);

                        ArrayList<Cart> carts = manager.fetchCurrentOrder(orderID);
                        session.setAttribute("currentCart", carts);
                        response.sendRedirect("CartPage.jsp");

                    } else {

                        Cart cart = new Cart(orderID, productID, productName, quantity, productPrice);
                        int cartID = cart.getCartID();
                        manager.addCartItem(cartID, orderID, productID, productName, 1, price);
                        ArrayList<Cart> carts = manager.fetchCurrentOrder(orderID);
                        session.setAttribute("currentCart", carts);
                        response.sendRedirect("CartPage.jsp");
                    }
                }
                else{
                    response.sendRedirect("CartPage.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
