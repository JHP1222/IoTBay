package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author jaehyeon
 */
public class ShowProductServlet extends HttpServlet{
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        int productID = Integer.parseInt(request.getParameter("id"));
        try{         
            Product orderedProduct = manager.fetchProductByID(productID);
            if(orderedProduct != null){
            session.setAttribute("orderedProduct", orderedProduct);
            session.setAttribute("currentProductID", orderedProduct.getProductID());
            session.setAttribute("currentProductName", orderedProduct.getProductName());
            session.setAttribute("currentProductPrice", orderedProduct.getProductPrice());
            request.getRequestDispatcher("ShowProduct.jsp").include(request, response);
            }
            else{
                request.getRequestDispatcher("Welcome.jsp").include(request, response);
            }
        }catch(SQLException ex){
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
