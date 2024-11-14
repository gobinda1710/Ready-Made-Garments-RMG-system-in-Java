
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String garmentId;
    public String garmentName;
    public String garmentDescription;
    public String garmentSize;
    public String garmentColor;
    public double garmentPrice;
    public int stockQuantity;

    public Garment(String garmentId, String garmentName, String garmentDescription, String garmentSize, String garmentColor, double garmentPrice, int stockQuantity) {
        this.garmentId = garmentId;
        this.garmentName = garmentName;
        this.garmentDescription = garmentDescription;
        this.garmentSize = garmentSize;
        this.garmentColor = garmentColor;
        this.garmentPrice = garmentPrice;
        this.stockQuantity = stockQuantity;
    }

    void updateStockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }

    double getDiscountedPrice(double discountPercentage) {
        return garmentPrice * (1 - discountPercentage / 100);
    }
}

class Fabric {

    public String fabricId;
    public String fabricType;
    public String fabricColor;
    public double pricePerUnit;

    public Fabric(String fabricId, String fabricType, String fabricColor, double pricePerUnit) {
        this.fabricId = fabricId;
        this.fabricType = fabricType;
        this.fabricColor = fabricColor;
        this.pricePerUnit = pricePerUnit;
    }

    double calculateFabricCost(double quantity) {
        return pricePerUnit * quantity;
    }
}

class Supplier {

    public String supplierId;
    public String supplierName;
    public String supplierContactInfo;
    private List<Fabric> fabricsSupplied = new ArrayList<>();

    public Supplier(String supplierId, String supplierName, String supplierContactInfo) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierContactInfo = supplierContactInfo;
    }

    void addFabricToSupplier(Fabric fabric) {
        fabricsSupplied.add(fabric);
    }

    List<Fabric> getSuppliedFabricList() {
        return fabricsSupplied;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    private List<Garment> orderedGarments = new ArrayList<>();
    private double finalAmount;

    public Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void addGarmentToOrder(Garment garment) {
        orderedGarments.add(garment);
    }

    double calculateFinalAmount(double discountPercentage) {
        finalAmount = 0;
        for (Garment garment : orderedGarments) {
            finalAmount += garment.getDiscountedPrice(discountPercentage);
        }
        return finalAmount;
    }

    void printOrderSummary(Customer customer, double discountPercentage) {
        System.out.println("== Order Summary ==");
        System.out.println("Customer Name: " + customer.customerName);
        System.out.println("Customer Email: " + customer.customerEmail);
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);

        for (Garment garment : orderedGarments) {
            System.out.println("Item: " + garment.garmentName + " | Original Price: " + garment.garmentPrice
                    + " | Discounted Price: " + garment.getDiscountedPrice(discountPercentage)
                    + " | Description: " + garment.garmentDescription);
        }

        System.out.println("Discount Applied: " + discountPercentage + "%");
        System.out.println("Total Amount: " + calculateFinalAmount(discountPercentage));
        System.out.println("=====================");
    }
}

class Customer {

    public String customerId;
    public String customerName;
    public String customerEmail;
    public String customerPhone;

    public Customer(String customerId, String customerName, String customerEmail, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    void placeOrderWithDiscount(Order order, double discountPercentage) {
        System.out.println("Placing Order for Customer: " + customerName);
        order.printOrderSummary(this, discountPercentage);
        System.out.println("Order Completed!");
    }
}

class Inventory {

    private List<Garment> garmentsList = new ArrayList<>();

    void addGarmentToInventory(Garment garment) {
        garmentsList.add(garment);
    }

    void removeGarmentFromInventory(String garmentId) {
        garmentsList.removeIf(g -> g.garmentId.equals(garmentId));
    }

    Garment searchGarmentById(String garmentId) {
        for (Garment garment : garmentsList) {
            if (garment.garmentId.equals(garmentId)) {
                return garment;
            }
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
