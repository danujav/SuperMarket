/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wholesaledist.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.wholesaledist.dbconnection.DBConnection;
import lk.wholesaledist.model.CustomerModel;

/**
 *
 * @author danu
 */
public class CustomerController {

    public static ArrayList<CustomerModel> getAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Customer");
        ArrayList <CustomerModel>customerList=new ArrayList<>();
        while(rst.next()){
            CustomerModel customer=new CustomerModel(rst.getString("CustId"), rst.getString("CustTitle"), rst.getString("CustName"), rst.getString("CustAddress"), rst.getString("City"), rst.getString("Province"), rst.getString("PostalCode"));
            customerList.add(customer);
        }
        return customerList;
    }
    
}
