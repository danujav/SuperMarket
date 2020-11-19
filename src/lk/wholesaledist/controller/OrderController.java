/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lk.wholesaledist.dbconnection.DBConnection;
import lk.wholesaledist.model.OrderModel;

/**
 *
 * @author danu
 */
public class OrderController {

    public static boolean addOrder(OrderModel orderModel) throws ClassNotFoundException, SQLException {
        Connection  connection = DBConnection.getInstance().getConnection();
       
        try{
        connection.setAutoCommit(false);
        PreparedStatement stm = connection.prepareStatement("Insert into Orders (CustID) Values(?)");
        stm.setObject(1, orderModel.getCustID());
        boolean isAdded = stm.executeUpdate()>0;
        if(isAdded){
            boolean isAddDetail = OrderDetailController.addOrderDetail(orderModel.getOrdersList());
            if(isAddDetail){
                boolean isUpdated = ItemController.updateStock(orderModel.getOrdersList());
                if(isUpdated){
                    connection.commit();
                    return true;
                }
            }
        }
        connection.rollback();
        return false;
        }finally {
            connection.setAutoCommit(true);
        }
        
    }
    
}
