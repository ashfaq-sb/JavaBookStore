package com.ash.ood;

import javax.swing.*;
import java.util.ArrayList;

public class ProductHandler {
    ArrayList<Product> object = new ArrayList<Product>();

    public ProductHandler() {
    }

    public Product getProduct() {
        Product tempObject = null;
        for (Product anObject : this.object) {
            tempObject = anObject;
            //name[i]= tempObject.getName();
        }

        return tempObject;

    }

    public void showProduct() {
        for (Product tempObject : this.object) {
            tempObject.showProduct();
        }

    }

    public void addObject(Product object) {
        this.object.add(object);
    }

    public void removeObject(Product object) {
        this.object.remove(object);
    }

    public boolean exist(String name) {
        boolean exist = false;
        Product p;
        for (Product anObject : this.object) {
            p = anObject;
            if (p.getName().equals(name)) {
                System.out.println(p.getName() + ">>>>>>>>>>>");
                exist = true;
            } else {
                exist = false;
            }
        }

        return exist;
    }

    public Product getProductById(int id) {

        return this.object.get(id);
    }

    public String findProduct(int id) {
        String pDetails = "";
        if (this.object.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Products added Yet");
        } else {
            pDetails = this.object.get(id).productDetails();
        }
        return pDetails;
    }

    public void addTestObjects(int num) {
        for (int i = 0; i < num; i++) {
            this.addObject(new Software(Catagory.Software, "name" + i + "", 2.2 + i, 123 + i, "pubHouse" + i + "", "ram" + i + "", "proccesor" + i + ""));
            this.addObject(new Book(Catagory.Book, "name" + i + "", 2.2 + i, 123 + i, "pubHouse" + i + "", "author " + i + "", "isbn" + i + "", i));
            System.out.println("Test objects created");
        }
    }

    public ArrayList<Product> getCatList(Catagory c) {
        ArrayList<Product> l = new ArrayList<Product>();
        for (Product tempObject : this.object) {
            if (tempObject.getCat() == c) {
                l.add(tempObject);
            }
        }
        return l;
    }

}
