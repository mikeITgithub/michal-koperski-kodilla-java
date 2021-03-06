package com.kodilla.good.patterns.f2d;

import java.util.*;

public class GlutenFreeShop implements Producer {
    private String producerName;
    private List<String> products;

    public GlutenFreeShop(String producerName, List<String> products) {
        this.producerName = producerName;
        this.products = products;
    }

    public String getProducerName() {
        return producerName;
    }
    public List<String> getProducts() {
        products.add("apple");
        return products;
    }
    public void process() {
        System.out.println("Sending items from Cracow");
    }
}
