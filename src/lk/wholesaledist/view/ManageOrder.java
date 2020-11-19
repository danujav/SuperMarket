package lk.wholesaledist.view;


import lk.wholesaledist.view.AddCustomerForm;
import lk.wholesaledist.controller.ItemController;
import lk.wholesaledist.model.CustomerModel;
import lk.wholesaledist.model.ItemModel;
import lk.wholesaledist.model.OrderDetailModel;
import lk.wholesaledist.model.OrderModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import lk.wholesaledist.controller.CustomerController;
import lk.wholesaledist.controller.OrderController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danu
 */
public class ManageOrder extends javax.swing.JFrame {

    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
       // show date in OrderManageForm
        updateDate();
        
       // show date in OrderManageForm
        showTime();
        
       //show OrderID in OrderManageForm
        getOrderId();
        
        //load CustomerID
        loadAllCustomers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        itemCodeTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        qtyTxt = new javax.swing.JTextField();
        addToCartTxt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        removeBtn = new javax.swing.JButton();
        orderBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        discountTxt = new javax.swing.JTextField();
        addNewCustomerBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        makeBtn = new javax.swing.JButton();
        discountTxtLbl = new javax.swing.JLabel();
        discountLbl = new javax.swing.JLabel();
        totalTxtLbl = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        orderLbl = new javax.swing.JLabel();
        custIDTxt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(236, 240, 241));

        jPanel2.setBackground(new java.awt.Color(26, 188, 156));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(213, 0, 0));
        jLabel4.setText("Manage Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(241, 241, 241))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 39, 35));
        jLabel1.setText("Item Code");

        itemCodeTxt.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(62, 39, 35));
        jLabel2.setText("Quantity");

        qtyTxt.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        qtyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTxtActionPerformed(evt);
            }
        });

        addToCartTxt.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        addToCartTxt.setForeground(new java.awt.Color(62, 39, 35));
        addToCartTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/wholesaledist/pic/cart2.png"))); // NOI18N
        addToCartTxt.setText("Add to Cart");
        addToCartTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartTxtActionPerformed(evt);
            }
        });

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Description", "Qty Size", "Sale Price", "Discount", "New Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ItemTable);
        if (ItemTable.getColumnModel().getColumnCount() > 0) {
            ItemTable.getColumnModel().getColumn(1).setMinWidth(100);
        }

        removeBtn.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(62, 39, 35));
        removeBtn.setText("Remove Item");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        orderBtn.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        orderBtn.setForeground(new java.awt.Color(62, 39, 35));
        orderBtn.setText("Order");
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(62, 39, 35));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/wholesaledist/pic/BackButton.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(62, 39, 35));
        jLabel3.setText("Discount");

        discountTxt.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N

        addNewCustomerBtn.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        addNewCustomerBtn.setForeground(new java.awt.Color(62, 39, 35));
        addNewCustomerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/wholesaledist/pic/AddCustomer.png"))); // NOI18N
        addNewCustomerBtn.setText("ADD NEW CUSTOMER");
        addNewCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCustomerBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(62, 39, 35));
        jLabel6.setText("Customer ID");

        makeBtn.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        makeBtn.setForeground(new java.awt.Color(62, 39, 35));
        makeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/wholesaledist/pic/pay.png"))); // NOI18N
        makeBtn.setText("MAKE CUSTOMER ORDER");
        makeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeBtnActionPerformed(evt);
            }
        });

        discountTxtLbl.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        discountTxtLbl.setForeground(new java.awt.Color(65, 2, 2));

        discountLbl.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        discountLbl.setForeground(new java.awt.Color(4, 1, 9));

        totalTxtLbl.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        totalTxtLbl.setForeground(new java.awt.Color(65, 2, 2));

        totalLbl.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(4, 1, 9));

        dateLbl.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(202, 20, 20));

        timeLbl.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(202, 20, 20));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(62, 39, 35));
        jLabel5.setText("Order No");

        orderLbl.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        orderLbl.setForeground(new java.awt.Color(139, 2, 2));
        orderLbl.setText("orde");

        custIDTxt.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        custIDTxt.setSelectedItem(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(orderLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addComponent(addNewCustomerBtn))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(removeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(orderBtn)
                .addGap(158, 158, 158))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(130, 130, 130)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(addToCartTxt))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(itemCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88)
                                        .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(296, 296, 296)
                                        .addComponent(timeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(qtyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(discountTxtLbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(discountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(totalTxtLbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(makeBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(orderLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addNewCustomerBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLbl)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(itemCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(timeLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(qtyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addToCartTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeBtn)
                    .addComponent(orderBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(makeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discountTxtLbl)
                            .addComponent(discountLbl)
                            .addComponent(totalTxtLbl)
                            .addComponent(totalLbl))
                        .addGap(24, 24, 24))
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     public static void removeAllCustomer(){
         custIDTxt.removeAllItems();
     }
     public static void loadAllCustomers() {
        try {
            ArrayList<CustomerModel> customers = CustomerController.getAllCustomers();
            for (CustomerModel c : customers) {
                custIDTxt.addItem(c.getCustID());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void updateDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = sdf.format(date);
        dateLbl.setText(orderDate);
                
        
        
    }
    
    void showTime(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String orderDate = sdf.format(date);
                timeLbl.setText(orderDate);
            }
        }
        
        
        
        ).start();
    }
        
    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
       
        try{
        int selectedRowIndex = ItemTable.getSelectedRow();
        model.removeRow(selectedRowIndex);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Please Select the Item to Delete!");
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
        new CashierForm().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addToCartTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartTxtActionPerformed
        
        try { 
            ItemModel item = ItemController.searchItemCode(itemCodeTxt.getText());
            double unitPrice = item.getUnitPrice();
            int qty = Integer.parseInt(qtyTxt.getText());
            
            double salePrice = unitPrice * qty;
            
            double discount = Double.parseDouble(discountTxt.getText());
            double newPrice = salePrice - discount;
             
            if(item != null){
                DefaultTableModel dtm = (DefaultTableModel) ItemTable.getModel();
                
                Object [] rowData = {item.getItemCode(),item.getDescription(), qty,salePrice,discount,newPrice};
                dtm.addRow(rowData);
                    
                itemCodeTxt.setText(null);
                qtyTxt.setText(null);
                discountTxt.setText(null);
            }else{
                JOptionPane.showMessageDialog(this, "Customer not found...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Item Not Found..");
        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Driver not found...");
        }
    }//GEN-LAST:event_addToCartTxtActionPerformed

    private void qtyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyTxtActionPerformed

    private void addNewCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCustomerBtnActionPerformed
        new AddCustomerForm().setVisible(true);
    }//GEN-LAST:event_addNewCustomerBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        int orderId = Integer.parseInt(orderLbl.getText());
        String custId =custIDTxt.getSelectedItem().toString();
         
        
        DefaultTableModel dtm = (DefaultTableModel) ItemTable.getModel();
        ArrayList<OrderDetailModel> orderDetailList = new ArrayList<>();
        for (int i = 0; i < dtm.getRowCount(); i++) {
                     
            String itemCode = (String) dtm.getValueAt(i, 0);
            int qty = (int) dtm.getValueAt(i, 2);
            double discount = (double) dtm.getValueAt(i, 4);
            OrderDetailModel orderDetail = new OrderDetailModel(orderId, itemCode, qty, discount);
            orderDetailList.add(orderDetail);
        }
        
        
        OrderModel orderModel = new OrderModel(orderId, custId, orderDetailList);
        try {
            boolean isAdded = OrderController.addOrder(orderModel);
            if(isAdded){
                JOptionPane.showMessageDialog(this, "Added Success");
                
                custIDTxt.addItem(null);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
    }//GEN-LAST:event_orderBtnActionPerformed

    private void getOrderId(){
        int orderID; 
        try {
               int orderId = ItemController.getOrderID();
               orderID = orderId + 1;
               orderLbl.setText(String.valueOf(orderID));
        } catch (SQLException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver not found...");
        }
    
    }
    
    private void makeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeBtnActionPerformed
        double discountSum = 0;
        for (int i = 0; i < ItemTable.getRowCount(); i++) {
            discountSum += Double.parseDouble(ItemTable.getValueAt(i, 4).toString());
        }
        
        double total = 0;
        for (int i = 0; i < ItemTable.getRowCount(); i++) {
            total += Double.parseDouble(ItemTable.getValueAt(i, 5).toString());
        }
        
        discountTxtLbl.setText("Net Discount");
        totalTxtLbl.setText("Total");
        
        discountLbl.setText(Double.toString(discountSum));
        totalLbl.setText(Double.toString(total));
        
        DefaultTableModel dtm = (DefaultTableModel) ItemTable.getModel();
        dtm.setRowCount(0);
        getOrderId();
        
        //System.out.println("Discount :"+discountSum);
        //System.out.println("Total :"+total);
    }//GEN-LAST:event_makeBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton addNewCustomerBtn;
    private javax.swing.JButton addToCartTxt;
    private javax.swing.JButton backBtn;
    private static javax.swing.JComboBox<String> custIDTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel discountLbl;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JLabel discountTxtLbl;
    private javax.swing.JTextField itemCodeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeBtn;
    private javax.swing.JButton orderBtn;
    private javax.swing.JLabel orderLbl;
    private javax.swing.JTextField qtyTxt;
    private javax.swing.JButton removeBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JLabel totalTxtLbl;
    // End of variables declaration//GEN-END:variables
}
