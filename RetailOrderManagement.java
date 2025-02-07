
// Base class Order
class Order {
    String orderId;
    String orderDate;
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    String getOrderStatus() {
        return "Order placed.";
    }
    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}
// Subclass ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;
    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    String getOrderStatus() {
        return "Order shipped. Tracking Number: " + trackingNumber;
    }
}
// Subclass DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    String getOrderStatus() {
        return "Order delivered on " + deliveryDate + ".";
    }
}
// Main class to test the system
public class RetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD001", "2025-02-07");
        ShippedOrder shippedOrder = new ShippedOrder("ORD002", "2025-02-06", "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD003", "2025-02-05", "TRK67890", "2025-02-07");
        order.displayOrderDetails();
        System.out.println();
        shippedOrder.displayOrderDetails();
        System.out.println();
        deliveredOrder.displayOrderDetails();
    }
}

