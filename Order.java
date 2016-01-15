package com.ash.ood;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    static int orderNoCounter = 0;
    private int orderNo = 0;
    private double orderTotal;
    private Customer c;
    private String orderDate;
    private int noOfitems = 0;
    private ArrayList<Product> products;
    private boolean dispatched;

    //Constructor
    public Order(double orderTotal, Customer c, int noOfitems, ArrayList<Product> products) {
        orderNoCounter++;
        orderNo = orderNoCounter;
        this.setNoOfitems(noOfitems);
        this.setC(c);
        this.setOrderTotal(orderTotal);
        this.setOrderDate(new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime()));
        this.products = new ArrayList<>();
        this.products.addAll(products);
        this.setDispatched(false);
    }

    Order() {

    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDetails() {
        return this.orderNo + " " + this.noOfitems + " " + this.orderDate + " " + (float) this.orderTotal + " " + this.isDispatched();

    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getNoOfitems() {
        return noOfitems;
    }

    public void setNoOfitems(int noOfitems) {
        this.noOfitems = noOfitems;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public ArrayList<Product> getProducts() {

        return this.products;
    }

    public void setPrdoucts(ArrayList<Product> products) {
        this.products = products;
    }

    public Product getEachProduct() {
        Product p = null;

        for (int i = 0; i < this.getProducts().size(); i++) {
            p = this.getProducts().get(i);
        }
        return p;
    }

    public String getEachProductDetails() {
        String s = "";

        for (int i = 0; i < this.getProducts().size(); i++) {
            s = this.getProducts().get(i).productDetails();
        }
        return s;
    }

    public boolean isDispatched() {
        return dispatched;
    }

    public void setDispatched(boolean dispatched) {
        this.dispatched = dispatched;
    }

    public int getOrderNo() {
        return orderNo;
    }
}
