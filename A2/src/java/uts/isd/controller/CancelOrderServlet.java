package uts.isd.controller;

/**
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

public class CancelOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int orderID = Integer.parseInt(session.getAttribute("currentOrderID").toString());
        try {
            manager.deleteAllCart(orderID);
            manager.deleteOrder(orderID);
            session.invalidate();
            response.sendRedirect("index.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(RemoveItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
