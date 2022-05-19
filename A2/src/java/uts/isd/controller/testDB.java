
package uts.isd.controller;

import uts.isd.model.dao.DBManager;
import uts.isd.model.dao.DBConnector;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Cart;
import uts.isd.model.Order;
import uts.isd.model.Product;

public class testDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    
    public static void main(String[] args) throws SQLException{
        (new testDB()).runQueries();
    
    }
    
    public testDB(){
        try{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        }       
        catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(testDB.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
    
    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private char readProducts(){
        System.out.print("Add more product ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException{
        char c; 
        while ((c = readChoice()) != '*'){
            switch (c){
                case 'C':
                   //testAdd();
                    testDeleteCart();
                    break;
                case 'R': 
                    testRead();
                    break;
                /*
                case ' U': ;
                    testUpdate();
                    break;
                    
                case 'D': ;
                    testDelete();
                    break;
                    */
                case 'S': 
                   //showCart();
                    //showProduct();

                    break;
                default:
                    System.out.println("Unknown Command");
                    break;         
            }
            
        
        }
    }
    
    private void testAdd(){
        int orderID = 9;
        int customerID = 1;
        
        try{
            db.addOrder(customerID);
        }
        catch (SQLException ex){
                Logger.getLogger(testDB.class.getName()).log(Level.SEVERE, null, ex);       
        }
        
        
        System.out.println("Order is added to the database.");
    }
     
    private void testRead() throws SQLException{
        System.out.print("Order ID: ");
        int oid = in.nextInt();
         System.out.print("P ID: ");
        int cid = in.nextInt(); 

    }
    
    private void showAll(){
        try{
            ArrayList<Order> orders = db.fetchOrders(1);
           
            System.out.println("Orders: ");

            orders.stream().forEach((order) -> {
              
                System.out.printf("%-20s %-30s %-20s \n" ,order.getCustomerID(),order.getOrderID(),order.getOrderDate());      
                });
        System.out.println();
        }
        
        catch (SQLException ex){
                Logger.getLogger(testDB.class.getName()).log(Level.SEVERE, null, ex);       
        }

    }
    private void testDeleteCart() throws SQLException{
        
     System.out.print("Order ID: ");
    int oid = in.nextInt();
     System.out.print("P ID: ");
    int cid = in.nextInt(); 
    db.deleteCartItem(oid, cid);
    
    
    
    
    
    }
    
    private void showCart(){
    try{
       ArrayList<Cart> cart = db.fetchCart(1);
                cart.stream().forEach((cartItem) -> {
              
                System.out.printf("%-20s %-30s %-20s \n" ,cartItem.getCartID(),cartItem.getOrderID(),cartItem.getProductID());      
                });
        System.out.println();
    
    }catch (SQLException ex){
                Logger.getLogger(testDB.class.getName()).log(Level.SEVERE, null, ex);       
        }
    }
    
    

    




}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

