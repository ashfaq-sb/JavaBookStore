package com.ash.ood;

import java.util.ArrayList;

public class OrderHandler {
    ArrayList<Order> object = new ArrayList<Order>();

    public OrderHandler() {
    }

    public Order getOrder() {
        Order order = null;
        for (Order anObject : this.object) {
            order = anObject;
            //name[i]= tempObject.getName();
        }

        return order;

    }

    public void showOrder() {
        for (Order tempObject : this.object) {
            // tempObject..showProduct();
        }

    }

    public void addObject(Order object) {
        this.object.add(object);
    }

    public void removeObject(Order object) {
        this.object.remove(object);
    }

    public Order getOrderbyId(int id) {
        return this.object.get(id);
    }

    public String getProductDetails() {
        Product p;
        String s = "";
        //int size=this.getOrder().getPrdoucts().size();
        for (Order anObject : this.object) {
            int size = anObject.getProducts().size();

            Order o = anObject;
            for (int j = 0; j < size; j++) {
                p = o.getProducts().get(j);

                s = s + o.getOrderDetails() + " " + o.getC().getCustomerDetails() + " " + p.productDetails();
            }
        }

        return s;

    }

    public String getPDetails() {
        Product p;
        String s = "";

        for (Order anObject : this.object) {
            int size = anObject.getProducts().size();

            Order o = anObject;
            boolean once = true;
            for (int j = 0; j < size; j++) {
                p = o.getProducts().get(j);

                if (once) {
                    s = s + "CName CAdress Pid PName PCost PHouse PAuthor";
                    s = s + o.getC().getCustomerDetails() + " " + p.productDetails() + "\n";
                    once = false;
                } else {

                    s = o.getC().getCustomerDetails() + " " + p.productDetails() + "\n";
                }
            }
        }

        return s;

    }

}
