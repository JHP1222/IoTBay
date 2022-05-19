package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author jaehyeon
 */
public class Product implements Serializable{
    private int productID;
    private String productName;
    private String productType;
    private double productPrice;
    private int productQuantity;

    public Product() {
    }

    public Product(int productID, String productName, String productType, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    public Product(int productID, String productName, String productType, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

   

    
    
    
}
