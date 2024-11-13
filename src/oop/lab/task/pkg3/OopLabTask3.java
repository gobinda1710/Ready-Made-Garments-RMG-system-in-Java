package oop.lab.task.pkg3;
//importing list and array list

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return discount;
    }
}


public class OopLabTask3 {

    public static void main(String[] args) {
        Garment g1 = new Garment();
        g1.name = "Silk";
        g1.description = "Good Product";
        g1.price= 600;
        double x = g1.calculateDiscountPrice(10);
        System.out.println(x);

    }

}