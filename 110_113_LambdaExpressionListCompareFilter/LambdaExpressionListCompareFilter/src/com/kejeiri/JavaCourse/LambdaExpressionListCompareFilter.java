package com.kejeiri.JavaCourse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class LambdaExpressionListCompareFilter {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"MacBookPro",2200.00));
        products.add(new Product(2,"TV",7705.55));
        products.add(new Product(3,"Google plus phone",700.00));
        products.add(new Product(4,"Iphone 7",800.00));
        products.add(new Product(5,"Asus Tablet",165.00));

        System.out.println("Old way");
        for(Product product: products ) {
            System.out.printf("%d %s %s%n", product.getId(), product.getName(), product.getPrice());
        }

        System.out.println("=========================Lambda================================");
        products.forEach(product ->
                System.out.printf("%d %s %s%n", product.getId(), product.getName(), product.getPrice()));


        System.out.println("=========================Lambda: Sorting old way=======================");
        Collection<Product> productCollection = products;
        Collections.sort(products,(p1,p2) -> {
            return  p1.getName().compareTo(p2.getName());
        });
        productCollection.forEach(product ->
                System.out.printf("%d %s %s%n", product.getId(), product.getName(), product.getPrice()));
        System.out.println("=========================Lambda: Sorting=========================");
        Collections.sort(products,Comparator.comparing(product->product.getName()));
        productCollection.forEach(product ->
                System.out.printf("%d %s %s%n", product.getId(), product.getName(), product.getPrice()));


        System.out.println("=========================Lambda: Sorting by price=================");
        Collections.sort(products,Comparator.comparing(product->product.getPrice()));
        productCollection.forEach(product ->
                System.out.printf("%d %s %s%n", product.getId(), product.getName(), product.getPrice()));

        /*****************************************************************************************
         * Stream is a generic interface, not to confuse with input/out stream
         * here : is sequence that support a different kind of operations to perform computation
         * upon those elements. Example : filtering!
         *******************************************************************************************/
        Stream<Product> search = products.stream().filter(product -> product.getPrice()>1000);
        System.out.println("===========searching product where price greater that 1000.00===========");
        search.forEach(product ->
                System.out.printf("%d %s %s%n", product.getId(), product.getName(), product.getPrice()));




    }






}
class Product{
    private int id;
    private String name;
    private double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
