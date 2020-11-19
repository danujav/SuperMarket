/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.model;

import java.util.ArrayList;

/**
 *
 * @author danu
 */
public class OrderModel {
    private int orderID;
    private String custID;
    private ArrayList<OrderDetailModel> ordersList;

    public OrderModel() {
    }

    public OrderModel(int orderID, String custID, ArrayList<OrderDetailModel> ordersList) {
        this.orderID = orderID;
        this.custID = custID;
        this.ordersList = ordersList;
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
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the ordersList
     */
    public ArrayList<OrderDetailModel> getOrdersList() {
        return ordersList;
    }

    /**
     * @param ordersList the ordersList to set
     */
    public void setOrdersList(ArrayList<OrderDetailModel> ordersList) {
        this.ordersList = ordersList;
    }

    
    
    
}
