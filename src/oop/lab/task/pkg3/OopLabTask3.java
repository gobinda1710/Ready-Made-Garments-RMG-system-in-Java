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
class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    double calculateCost(double meters) {
        double newPrice = pricePerMeter * meters;
        return newPrice;
    }
}
class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    //List
    List<Fabric> suppliedFabric = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    double calculateTotalAmount() {
        for (Garment g : garments) {
            totalAmount = totalAmount + g.price;
        }
        return totalAmount;
    }

    void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order Details");
        System.out.println("--------------------------");
        for (Garment g : garments) {
            System.out.println("Name: " + g.name);
            System.out.println("Price: " + g.price);
            System.out.println("Description: " + g.description);
            System.out.println("--------------------------");
        }
    }
}
class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }

//    List<Order> viewOrders() {
//        
//    }
}

<<<<<<< HEAD

class Inventory {

    List<Garment> garments;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        garments.remove(id);
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if(g.id == id)
                return g;
        }
        return null;
    }
}
public class OopLabTask3 {

    public static void main(String[] args) {

        Garment garment1 = new Garment("G1", "Silk Blouse", "Elegant Silk Blouse", "M", "Red", 750, 15);
        Garment garment2 = new Garment("G2", "Denim Jeans", "Classic Blue Jeans", "L", "Blue", 550, 30);

        Order newOrder = new Order("ORD101", new Date());
        newOrder.addGarmentToOrder(garment1);
        newOrder.addGarmentToOrder(garment2);

        Customer customer = new Customer("CUST01", "Gobinda", "das23105101193.diu.edu.bd", "0175116908");
        customer.placeOrderWithDiscount(newOrder, 12.5);
    }
}
