package com.ash.ood;

public class Book extends Product {

    private String author, ISBN;
    private int noOfPages;

    public Book(Catagory cat, String name, Double cost, int yearOfPubl, String publishingHouse, String author, String ISBN, int pages) {
        super(cat, name, cost, yearOfPubl, publishingHouse);
        this.setAuthor(author);
        this.setISBN(ISBN);

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public void showProduct() {
        super.showProduct();
        System.out.println(getAuthor() + " " + getISBN() + " " + getNoOfPages());
    }

    public String productDetails() {

        return super.productDetails() + " " + getAuthor() + " " + getISBN() + " " + getNoOfPages();

    }
}