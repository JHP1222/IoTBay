package uts.isd.model.dao;

import uts.isd.model.Product;
import uts.isd.model.Cart;
import uts.isd.model.Order;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public Order findOrder(int orderId, int customerId) throws SQLException {
        String fetch = "select * from APP.ORDERS where ORDER_ID = " + orderId + "and customer_id=" + customerId;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int orderID = rs.getInt(1);
            int customerID = rs.getInt(2);
            if (orderID == orderId && customerID == customerId) {
                Date orderDate = rs.getDate(4);
                double totalPrice = rs.getDouble(3);
                return new Order(orderID, customerID, orderDate, totalPrice);
            }
        }
        return null;
    }
    public ArrayList<Order> findOrderByDate(String orderDate, int customerId) throws SQLException {
        String fetch = "select * from APP.ORDERS where order_date = '" + orderDate + "'and customer_id=" + customerId;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> orders = new ArrayList<Order>();
        while (rs.next()) {
            int orderID = rs.getInt(1);
            int customerID = rs.getInt(2);
            Date setOrderDate =  rs.getDate(4);
            double totalPrice = rs.getDouble(3);
            orders.add(new Order(orderID, customerID, setOrderDate, totalPrice));
            
        }
        return orders;
    }


    public Order findGuestOrder(int orderId) throws SQLException {
        String fetch = "select * from APP.ORDERS where ORDER_ID = " + orderId;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int orderID = rs.getInt(1);
            if (orderID == orderId) {
                Date orderDate = rs.getDate(4);
                double totalPrice = rs.getDouble(3);
                return new Order(orderID, orderDate, totalPrice);
            }
        }
        return null;
    }

    public ArrayList<Order> findOrders(int orderID, int customerID) throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        String fetch = "select * from APP.ORDERS where ORDER_ID = " + orderID + "and customer_id=" + customerID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            Date orderDate = rs.getDate(4);
            double totalPrice = rs.getDouble(3);
            orders.add(new Order(orderID,customerID,orderDate,totalPrice));
        }
        return orders;

    }

    public int addOrder(int customerID) throws SQLException {
        st.executeUpdate("INSERT INTO app.orders (customer_id,total_price,order_date) VALUES (" + customerID + ", null,null)");
        ResultSet results = st.executeQuery("SELECT order_id FROM app.orders WHERE CUSTOMER_ID=" + customerID + " ORDER BY order_id DESC");
        results.next();
        return results.getInt("order_id");
    }

    public void addCartItem(int cartID, int orderID, int productID, String productName, int quantity, double totalPrice) throws SQLException {
        st.executeUpdate("INSERT INTO app.cart (order_id, product_id,quantity,Price,cart_ID,product_name) VALUES (" + orderID + "," + productID + "," + quantity + "," + totalPrice + "," + cartID + ",'" + productName + "')");

    }

    public int addGuestOrder() throws SQLException {
        st.executeUpdate("INSERT INTO app.orders (customer_id,total_price,order_date) VALUES (null,null,null)");
        ResultSet results = st.executeQuery("SELECT order_id FROM app.orders ORDER BY order_id DESC fetch first 1 rows only");
        results.next();
        return results.getInt("order_id");
    }
/*
    public void updateOrderTotalPrice(int ID, int customerID, double totalPrice) throws SQLException {
        st.executeUpdate("UPDATE App.ORDERS SET Order_id=" + ID + ", customer_id= " + customerID + ", total_price=" + totalPrice + "WHERE ORDER_ID=" + ID + " AND USERID=" + customerID);
    }*/

    public void updateQuantity(int orderID, int productID, int quantity) throws SQLException {
        st.executeUpdate("UPDATE app.cart SET quantity =" + quantity + " WHERE order_id= " + orderID + "and product_id=" + productID);
    }

    public void updateOrderDetail(int ID, double totalPrice, String date) throws SQLException {
        st.executeUpdate("UPDATE App.ORDERS SET total_price=" + totalPrice + ", order_date= '" + date + "'WHERE ORDER_ID=" + ID);
    }

    public void deleteOrder(int ID) throws SQLException {
        st.executeUpdate("DELETE FROM app.ORDERS WHERE ORDER_ID=" + ID);
    }

    public void deleteAllCart(int ID) throws SQLException {
        st.executeUpdate("DELETE FROM app.cart WHERE ORDER_ID=" + ID);
    }

    public void deleteCartItem(int orderID, int productID) throws SQLException {
        st.executeUpdate("DELETE FROM app.cart WHERE ORDER_ID=" + orderID + "and product_id=" + productID);
    }

    public ArrayList<Order> fetchOrders(int customerID) throws SQLException {
        String fetch = "select * from App.ORDERS where customer_id=" + customerID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            Date orderDate = rs.getDate(4);
            double totalPrice = rs.getDouble(3);
            temp.add(new Order(id, customerID, orderDate, totalPrice));
        }
        return temp;
    }

    public ArrayList<Cart> fetchCart(int orderID) throws SQLException {
        String fetch = "select * from App.cart where order_id=" + orderID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Cart> temp = new ArrayList();
        while (rs.next()) {
            int cartID = rs.getInt(1);
            int productID = rs.getInt(2);
            int quantity = rs.getInt(3);
            double totalPrice = rs.getDouble(4);
            String productName = rs.getString(6);
            temp.add(new Cart(cartID, orderID, productID, productName, quantity, totalPrice));

        }
        return temp;
    }
    /*
    public String fetchProductName(int pID) throws SQLException {
        String fetch = "select * from App.product where device_id=" + pID;
        ResultSet rs = st.executeQuery(fetch);
        Product product = new Product();
        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            product.setProductID(productID);
            product.setProductName(productName);
        }
        return product.getProductName();
    }*/

    public Product fetchProductByID(int pID) throws SQLException {
        String fetch = "select * from App.product where device_id=" + pID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String productType = rs.getString(3);
            double productPrice = rs.getDouble(4);
            return new Product(productID, productName, productType, productPrice);
        }
        return null;
    }
    
    public Cart fetchCartItem(int orderID, int productID) throws SQLException{
        String fetch = "select * from App.cart where order_ID=" + orderID + "and product_ID=" + productID;
        ResultSet rs = st.executeQuery(fetch);
        while(rs.next()){
            String productName = rs.getString(6);
            int quantity = rs.getInt(3);
            double price = rs.getDouble(4);
            int cartID = rs.getInt(5);
            return new Cart(cartID,orderID,productID,productName, quantity,price);
        }
        return null;
    
    }
    
    public ArrayList<Cart> fetchCurrentOrder(int orderID) throws SQLException {
        String fetch = "select * from APP.cart where order_ID=" + orderID + "";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Cart> temp = new ArrayList<Cart>();
        while (rs.next()) {
            int cartID = rs.getInt(5);
            int productID = rs.getInt(2);
            String productName = rs.getString(6);
            int quantity = rs.getInt(3);
            double price = rs.getDouble(4);
            temp.add(new Cart(cartID, orderID, productID, productName, quantity, price));
        }
        return temp;
    }

    public ArrayList<Product> listProducts() throws SQLException {
        String fetch = "select * from APP.PRODUCT";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> products = new ArrayList<>();

        while (rs.next()) {
            String product_id = rs.getString(1);
            int real_id = Integer.parseInt(product_id);
            String product_name = rs.getString(2);
            String product_type = rs.getString(3);
            String product_unit_price = rs.getString(4);
            double real_price = Double.parseDouble(product_unit_price);
            String product_quantity = rs.getString(5);
            int real_quantity = Integer.parseInt(product_quantity);
            Product product = new Product(real_id, product_name, product_type, real_price, real_quantity);
            products.add(product);
        }
        return products;
    }

}
