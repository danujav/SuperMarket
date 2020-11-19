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
public class MovbleModel {
    private String itemCode;
    private int movble;

    public MovbleModel() {
    }

    public MovbleModel(String itemCode, int movble) {
        this.itemCode = itemCode;
        this.movble = movble;
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
     * @return the movble
     */
    public int getMovble() {
        return movble;
    }

    /**
     * @param movble the movble to set
     */
    public void setMovble(int movble) {
        this.movble = movble;
    }
    
    
}
