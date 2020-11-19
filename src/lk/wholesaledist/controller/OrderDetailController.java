/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.wholesaledist.dbconnection.DBConnection;
import lk.wholesaledist.model.OrderDetailModel;

/**
 *
 * @author danu
 */
class OrderDetailController {

    static boolean addOrderDetail(ArrayList<OrderDetailModel> ordersList) throws ClassNotFoundException, SQLException {
        for(OrderDetailModel orderDetail : ordersList){
            boolean isAdded = addOrderDetail(orderDetail);
            if(!isAdded){
                return false;
            }
        }
        return true;
    }
    
    static boolean addOrderDetail(OrderDetailModel orderDetail) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into OrderDetail values(?,?,?,?)");
        stm.setObject(1, orderDetail.getOrderID());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getOrderQTY());
        stm.setObject(4, orderDetail.getDiscount());
        
        return stm.executeUpdate()>0;
    
    }
    
}
