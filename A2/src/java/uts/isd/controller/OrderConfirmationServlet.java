package uts.isd.controller;

/**
 *
 * @author jaehyeon
 */
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import uts.isd.model.dao.DBManager;

public class OrderConfirmationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int orderID = Integer.parseInt(session.getAttribute("currentOrderID").toString());
       
        try{
             //find current order using currentorderid
            ArrayList<Cart> cart = manager.fetchCart(orderID);
            // update order database using the cart information 
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            session.setAttribute("date", date);
            double totalPrice = Double.parseDouble(session.getAttribute("totalPrice").toString());
            if(!cart.isEmpty()){
                manager.updateOrderDetail(orderID, totalPrice,date);
                session.setAttribute("date", date);
                response.sendRedirect("OrderConfirmation.jsp");
            }else{
                response.sendRedirect("Welcome.jsp"); 
            }
        
        
        }catch(SQLException ex){
                    Logger.getLogger(OrderConfirmationServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

}
