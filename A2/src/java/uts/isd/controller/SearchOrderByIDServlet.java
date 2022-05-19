
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Cart;

public class SearchOrderByIDServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int customerID = Integer.parseInt(session.getAttribute("currentCustomerID").toString());
        
        try{
            Order orders =manager.findOrder(orderID, customerID);
            session.setAttribute("SearchOrderByIDResultOrder", orders);
            ArrayList<Cart> cart =manager.fetchCart(orderID);
            session.setAttribute("SearchOrderByIDResultCart", cart);
            response.sendRedirect("SearchOrderByIDResult.jsp");
        }catch (SQLException ex) {
            Logger.getLogger(SearchOrderByIDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
