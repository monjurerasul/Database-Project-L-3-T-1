/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hasan.Models;

/**
 *
 * @author Hasan Murad
 */
public class Depository {
    public int PRODUCT_ID;
    public int STOCK_AMOUNT;
    public String PRODUCT_NAME;      
    public int TYPE_ID;             
    public int PRICE;
    
    public Depository() {
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public int getSTOCK_AMOUNT() {
        return STOCK_AMOUNT;
    }

    public void setSTOCK_AMOUNT(int STOCK_AMOUNT) {
        this.STOCK_AMOUNT = STOCK_AMOUNT;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    

    public int getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(int TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "Depository{" + "PRODUCT_ID=" + PRODUCT_ID + ", STOCK_AMOUNT=" + STOCK_AMOUNT + ", PRODUCT_NAME=" + PRODUCT_NAME + ", TYPE_ID=" + TYPE_ID + ", PRICE=" + PRICE + '}';
    }
    
}
