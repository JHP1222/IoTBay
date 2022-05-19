package uts.isd.controller;

/**
 *
 * @author jaehyeon
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

public class CurrentOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        if (session.getAttribute("currentCustomerID") != null) {
            int customerID = Integer.parseInt(session.getAttribute("currentCustomerID").toString());

            if (customerID != 0) {
                try {
                    int orderID = manager.addOrder(customerID);
                    session.setAttribute("currentOrderID", orderID);
                    request.getRequestDispatcher("Welcome.jsp").include(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    if (session.getAttribute("currentOrderID") == null) {
                        int orderID = manager.addGuestOrder();
                        session.setAttribute("currentOrderID", orderID);
                        response.sendRedirect("Welcome.jsp");
                    } else {
                        response.sendRedirect("Welcome.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CurrentOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

