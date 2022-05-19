package uts.isd.controller;

import uts.isd.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
/**
 *
 * @author jaehyeon
 */
public class OrderCartHistoryServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");    
        String stringOrderID = request.getParameter("orderID");
        int orderID = Integer.parseInt(stringOrderID);
           try{
            ArrayList<Cart> cart = manager.fetchCart(orderID);        
            session.setAttribute("cartDetail", cart);
            request.getRequestDispatcher("OrderHistoryCart.jsp").forward(request,response);
        }catch (SQLException ex) {
            Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
