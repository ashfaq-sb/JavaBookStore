package com.ash.ood;


public class Software extends Product {
    private String RAM, processorRequired;

    public Software(Catagory cat, String name, Double cost, int yearOfPubl, String publishingHouse, String processorRequired, String RAM) {
        super(cat, name, cost, yearOfPubl, publishingHouse);
        this.setProcessorRequired(processorRequired);
        this.setRAM(RAM);

    }

    public String getProcessorRequired() {
        return processorRequired;
    }

    public void setProcessorRequired(String processorRequired) {
        this.processorRequired = processorRequired;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String rAM) {
        RAM = rAM;
    }

    public void showProduct() {
        super.showProduct();
        System.out.println(getRAM() + " " + getProcessorRequired());
    }

    public String productDetails() {

        return super.productDetails() + " " + getRAM() + " " + getProcessorRequired();

    }
}

