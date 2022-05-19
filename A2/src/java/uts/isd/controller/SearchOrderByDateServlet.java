
package uts.isd.controller;

/**
 *
 * @author jaehyeon
 */

import uts.isd.model.Order;
import uts.isd.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Cart;

public class SearchOrderByDateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        String orderedDate = request.getParameter("orderDate").toString();
        int customerID = Integer.parseInt(session.getAttribute("currentCustomerID").toString());
        
        
        
        try{
            
            ArrayList<Order> orders =manager.findOrderByDate(orderedDate, customerID);
            session.setAttribute("SearchOrderByDateResultOrder", orders);
            //ArrayList<Cart> cart =manager.fetchCart(orders.getOrderID());
           // session.setAttribute("SearchOrderByIDResultCart", cart);
            response.sendRedirect("SearchOrderByDateResult.jsp");
        }catch (SQLException ex) {
            Logger.getLogger(SearchOrderByDateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}