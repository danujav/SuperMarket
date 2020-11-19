/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.model;

/**
 *
 * @author danu
 */
public class OrderDetailModel {
    private int orderID;
    private String itemCode;
    private int orderQTY;
    private double discount;

    public OrderDetailModel() {
    }

    public OrderDetailModel(int orderID, String itemCode, int orderQTY, double discount) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.orderQTY = orderQTY;
        this.discount = discount;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the orderQTY
     */
    public int getOrderQTY() {
        return orderQTY;
    }

    /**
     * @param orderQTY the orderQTY to set
     */
    public void setOrderQTY(int orderQTY) {
        this.orderQTY = orderQTY;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

  
    
}
