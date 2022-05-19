
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

/**
 *
 * @author jaehyeon
 */
/*
public class ViewCartServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        int orderID = Integer.parseInt(session.getAttribute("currentOrderID").toString());
        int customerID = Integer.parseInt(session.getAttribute("currentCustomerID").toString());
       
        if(customerID !=0){
            try{
            ArrayList<Cart> cart = manager.fetchCurrentOrder(orderID);
            session.setAttribute("currentCart", cart);
            Order order = manager.findOrder(orderID, customerID);
            session.setAttribute("currentOrder", order);
            request.getRequestDispatcher("CartPage.jsp").include(request, response);
            }catch (SQLException ex) {
                   Logger.getLogger(ViewCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try{
                ArrayList<Cart> cart = manager.fetchCurrentOrder(orderID);
                session.setAttribute("currentCart", cart);
                response.sendRedirect("CartPage.jsp");
            }catch (SQLException ex) {
                Logger.getLogger(ViewCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
*/