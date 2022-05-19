package uts.isd.controller;

import uts.isd.model.Order;
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
import uts.isd.model.Customer;

/**
 *
 * @author jaehyeon
 */
public class OrderHistoryServlet extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        try{
            ArrayList<Order> orders = manager.fetchOrders(customer.getCustomerId());
            session.setAttribute("orders", orders);
            request.getRequestDispatcher("ViewOrderHistory.jsp").forward(request,response);
        }catch (SQLException ex) {
            Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
