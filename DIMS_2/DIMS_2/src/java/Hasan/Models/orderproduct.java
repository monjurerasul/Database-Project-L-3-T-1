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
public class orderproduct {

    public int RETAILER_ID;
    public int EMPLOYEE_ID;
    public int PRODUCT_ID;
    public String ORDER_DATE;
    public int QUANTITY;
    public int  status;
    public String first_name;
    public String last_name;
    public String retailer_name;
    public String product_name;
    public int price;

    public orderproduct() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
         
    public int getRETAILER_ID() {
        return RETAILER_ID;
    }

    public void setRETAILER_ID(int RETAILER_ID) {
        this.RETAILER_ID = RETAILER_ID;
    }

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getORDER_DATE() {
        return ORDER_DATE;
    }

    public void setORDER_DATE(String ORDER_DATE) {
        this.ORDER_DATE = ORDER_DATE;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRetailer_name() {
        return retailer_name;
    }

    public void setRetailer_name(String retailer_name) {
        this.retailer_name = retailer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "orderproduct{" + "RETAILER_ID=" + RETAILER_ID + ", EMPLOYEE_ID=" + EMPLOYEE_ID + ", PRODUCT_ID=" + PRODUCT_ID + ", ORDER_DATE=" + ORDER_DATE + ", QUANTITY=" + QUANTITY + ", first_name=" + first_name + ", last_name=" + last_name + ", retailer_name=" + retailer_name + ", product_name=" + product_name + '}';
    }

}
