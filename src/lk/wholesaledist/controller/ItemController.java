/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.controller;

import lk.wholesaledist.model.ItemModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import lk.wholesaledist.dbconnection.DBConnection;
import lk.wholesaledist.model.CustomerModel;
import lk.wholesaledist.model.MovbleModel;
import lk.wholesaledist.model.OrderDetailModel;
import lk.wholesaledist.model.OrderModel;
import lk.wholesaledist.model.PasswordModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author danu
 */
public class ItemController {

    public static boolean addItem(ItemModel item) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Item Values(?,?,?,?,?)");
        stm.setObject(1, item.getItemCode());
        stm.setObject(2, item.getDescription());
        stm.setObject(3, item.getPackSize());
        stm.setObject(4, item.getUnitPrice());
        stm.setObject(5, item.getQtyOnHand());
 
        int res = stm.executeUpdate();
       
        return res>0;
    }

    public static ItemModel searchItemCode(String text) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Item where ItemCode = ?");
        stm.setObject(1, text);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            ItemModel item = new ItemModel(rst.getString("ItemCode"), rst.getString("Description"), rst.getString("PackSize"), rst.getDouble("unitPrice"), rst.getInt("QtyOnHand"));
            return item;
        }
        return null;
    }

    public static boolean updateItem(ItemModel item) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update Item set Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? where ItemCode = ?");
        stm.setObject(1, item.getDescription());
        stm.setObject(2, item.getPackSize());
        stm.setObject(3, item.getUnitPrice());
        stm.setObject(4, item.getQtyOnHand());
        stm.setObject(5, item.getItemCode());
        return stm.executeUpdate()>0;
    }

    public static boolean deleteItem(String text) throws ClassNotFoundException, SQLException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Item where ItemCode = '"+text+"'")>0;
    }

    public static boolean addCustomer(CustomerModel customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Customer Values(?,?,?,?,?,?,?)");
        stm.setObject(1, customer.getCustID());
        stm.setObject(2, customer.getCustTitle());
        stm.setObject(3, customer.getCustName());
        stm.setObject(4, customer.getCustAddress());
        stm.setObject(5, customer.getCity());
        stm.setObject(6, customer.getProvince());
        stm.setObject(7, customer.getPostalCode());
 
        int res = stm.executeUpdate();
       
        return res>0;
    }

    public static boolean addOrder(OrderModel order) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Orders (CustID) Values(?)");
        stm.setObject(1, order.getCustID());
        
        int res = stm.executeUpdate();
       
        return res>0;
    }

    public static boolean addOrderDetail(OrderDetailModel orderDetail) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into OrderDetail Values (?,?,?,?)");
        stm.setObject(1, orderDetail.getOrderID());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getOrderQTY());
        stm.setObject(4, orderDetail.getDiscount());
        
        int res = stm.executeUpdate();
       
        return res>0;
    }

    public static int getOrderID() throws SQLException, ClassNotFoundException {
         ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM Orders ORDER BY OrderID DESC LIMIT 1");
         return rst.next() ? rst.getInt("OrderID") : null;
    }

    public static boolean updateOrderDetail(OrderDetailModel orderDetailModel) throws SQLException, ClassNotFoundException {
        int temp = orderDetailModel.getOrderID() - 1;
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update OrderDetail set OrderID = ?  where OrderID = ?");
        
        stm.setObject(1, orderDetailModel.getItemCode());
        stm.setObject(2, temp);
        
        return stm.executeUpdate()>0;
    }

    

    public static boolean updateOrder(OrderModel item) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update Orders set CustID = ? where OrderID=?");
        stm.setObject(1, item.getCustID());
        stm.setObject(2, item.getOrderID());
        
        return stm.executeUpdate()>0;
    }

    public static ArrayList<ItemModel> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Item");
        ArrayList <ItemModel> itemList = new ArrayList<>();
        while(rst.next()){
            ItemModel item = new ItemModel(rst.getString("ItemCode"), rst.getString("Description"), rst.getString("PackSize"), rst.getDouble("UnitPrice"), rst.getInt("QtyOnHand"));
            itemList.add(item);
        }
        return itemList;
    }

    public static ArrayList<MovbleModel> getMostMobleItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT ItemCode, COUNT(ItemCode) AS MostMovble from OrderDetail GROUP  by ItemCode Order by MostMovble DESC LIMIT 1");
        ArrayList <MovbleModel> orderList = new ArrayList<>();
        while(rst.next()){
            MovbleModel mostMovbleModel = new MovbleModel(rst.getString("ItemCode"), rst.getInt("MostMovble"));
            orderList.add(mostMovbleModel);
        }
        return orderList;
    }

    public static ItemModel searchMostMovbleItem(String itemCode) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Item where ItemCode = ?");
        stm.setObject(1, itemCode);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            ItemModel item = new ItemModel(rst.getString("ItemCode"), rst.getString("Description"), rst.getString("PackSize"), rst.getDouble("unitPrice"), rst.getInt("QtyOnHand"));
            return item;
        }
        return null;
    }

    public static ArrayList<MovbleModel> getLeavbleItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT itemcode, COUNT(itemCode) AS LeastMovble from OrderDetail GROUP  by itemCode Order by LeastMovble ASC LIMIT 1");
        ArrayList <MovbleModel> orderList = new ArrayList<>();
        while(rst.next()){
            MovbleModel leastMovbleModel = new MovbleModel(rst.getString("ItemCode"), rst.getInt("LeastMovble"));
            orderList.add(leastMovbleModel);
        }
        return orderList;
    }

    public static ItemModel searchLeavbleItem(String itemCode) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Item where ItemCode = ?");
        stm.setObject(1, itemCode);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            ItemModel item = new ItemModel(rst.getString("ItemCode"), rst.getString("Description"), rst.getString("PackSize"), rst.getDouble("unitPrice"), rst.getInt("QtyOnHand"));
            return item;
        }
        return null;
    }

    public static boolean addDetailsCashier(PasswordModel password) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into password Values(?,?,?,?,?,?)");
        stm.setObject(1, password.getFirstName());
        stm.setObject(2, password.getLastName());
        stm.setObject(3, password.getUserName());
        stm.setObject(4, password.getPassword());
        stm.setObject(5, password.getRePassword());
        stm.setObject(6, password.getAddress());
        
        int res = stm.executeUpdate();
       
        return res>0;
    }

    public static PasswordModel searchItem(String text) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From password where userName = ?");
        stm.setObject(1, text);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            PasswordModel item=new PasswordModel(rst.getString("firstName"), rst.getString("lastName"), rst.getString("userName"), rst.getString("password"), rst.getString("rePassword"), rst.getString("address"));
            return item;
        }
        return null;
    }

    public static boolean addDetailsAdministor(PasswordModel password) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into passwordAdministor Values(?,?,?,?,?,?)");
        stm.setObject(1, password.getFirstName());
        stm.setObject(2, password.getLastName());
        stm.setObject(3, password.getUserName());
        stm.setObject(4, password.getPassword());
        stm.setObject(5, password.getRePassword());
        stm.setObject(6, password.getAddress());
        
        int res = stm.executeUpdate();
       
        return res>0;
    }

    public static PasswordModel searchItemAdministor(String text) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From passwordAdministor where userName = ?");
        stm.setObject(1, text);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            PasswordModel item=new PasswordModel(rst.getString("firstName"), rst.getString("lastName"), rst.getString("userName"), rst.getString("password"), rst.getString("rePassword"), rst.getString("address"));
            return item;
        }
        return null;
    }

    public static ItemModel searchItemNew(String text) throws SQLException, ClassNotFoundException {
         PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Item where ItemCode = ?");
        stm.setObject(1, text);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            ItemModel item = new ItemModel(rst.getString("ItemCode"), rst.getString("Description"), rst.getString("PackSize"), rst.getDouble("unitPrice"), rst.getInt("QtyOnHand"));
            return item;
        }
        return null;
    }

    public static boolean updateItemNew(ItemModel item) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update Item set QtyOnHand = ? where ItemCode = ?");
        stm.setObject(1, item.getQtyOnHand());
        stm.setObject(2, item.getItemCode());
        
        return stm.executeUpdate()>0;
    }

    static boolean updateStock(ArrayList<OrderDetailModel> ordersList) throws ClassNotFoundException, SQLException {
        for(OrderDetailModel orderDetail : ordersList){
            boolean isUpdated = updateStock(orderDetail);
            if(!isUpdated){
                return false;
            }
        }
        return true;
    }
    static boolean updateStock(OrderDetailModel orderDetail) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update Item set QtyOnHand =QtyOnHand - ? where ItemCode = ?");
         stm.setObject(1, orderDetail.getOrderQTY());
        stm.setObject(2, orderDetail.getItemCode());
        return stm.executeUpdate()>0;
    }

    

   

    
    
}
 