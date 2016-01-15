package com.ash.ood;


public class Product {
    static int idCounter = 0;
    private String name, publishingHouse;
    private Double cost;
    private int sold, yearOfPublication;
    private int pid = 0;
    private Catagory cat;

    public Product(Catagory cat, String name, Double cost, int yearOfPubl, String publishingHouse) {
        idCounter++;

        pid = idCounter;
        this.setCat(cat);
        this.publishingHouse = publishingHouse;
        this.name = name;
        this.cost = cost;
        this.yearOfPublication = yearOfPubl;
    }

    public Product() {
        // TODO Auto-generated constructor stub
    }

    public int getid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getYearOfPubl() {
        return yearOfPublication;
    }

    public void setYearOfPubl(int yearOfPubl) {
        this.yearOfPublication = yearOfPubl;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold += sold;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void showProduct() {
        System.out.print(getid() + " " + getName() + " " + getCost() + " " + getYearOfPubl() + " " + getPublishingHouse() + " ");

    }

    public Catagory getCat() {
        return cat;
    }

    public void setCat(Catagory cat) {
        this.cat = cat;
    }

    public String productDetails() {
        return this.getid() + " " + this.getName() + " " + this.getCost() + " " + this.getYearOfPubl() + " " + this.getPublishingHouse() + " ";

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
