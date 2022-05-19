package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jaehyeon
 */   
public class Order implements Serializable{
    private int orderID;
    private int customerID;
    private Date orderDate; 
    private double totalPrice;

    public Order() {
    }

    
    public Order(int customerID) {
        this.customerID = customerID;   
    }

    public Order(int orderID, int customerID, Date orderDate, double totalPrice) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public Order(int customerID, Date orderDate, double totalPrice) {       
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }
   
    // when guest
    public Order(Date orderDate,double totalPrice){
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
