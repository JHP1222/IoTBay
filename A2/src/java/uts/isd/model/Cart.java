package uts.isd.model;

import java.io.Serializable;
/**
 *
 * @author jaehyeon
 */
public class Cart implements Serializable{
    private int cartID;
    private int orderID;
    private int productID;
    private String productName;
    private int quantity;
    private double price;
    private static int cartIDCounter = 0;

    public Cart() {
    }

    
    // When creating new item to add to Cart 
    public Cart(int orderID, int productID,String productName, int quantity, double price) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
        this.cartID = Cart.cartIDCounter;
        Cart.cartIDCounter++; 
    }


    public Cart(int cartID, int orderID, int productID,String productName, int quantity, double price) {
        this.cartID = cartID;
        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getCartIDCounter() {
        return cartIDCounter;
    }

    public static void setCartIDCounter(int cartIDCounter) {
        Cart.cartIDCounter = cartIDCounter;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    
}
