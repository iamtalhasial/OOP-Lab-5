package foodlab;

public class FoodOrder {
    private final String orderId;
    private String customerName;
    private String address;
    private double[] itemPrices;
    private String status;
    private static int orderCount = 0;

    public FoodOrder(String orderId, String customerName, String address, double[] prices, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
        this.itemPrices = new double[3];
        for (int i = 0; i < 3; i++) {
            this.itemPrices[i] = (prices[i] >= 0) ? prices[i] : 0;
        }
        this.status = status;
        orderCount++;
    }

    public double calculateItemsTotal() {
        double sum = 0;
        for (double p : itemPrices) {
            sum += p;
        }
        return sum;
    }

    public void advanceStatus() {
        if (status.equals("Preparing")) {
            status = "Ready";
        } else if (status.equals("Ready")) {
            status = "Picked Up";
        } else if (status.equals("Picked Up")) {
            status = "Delivered";
        }
        System.out.println(orderId + " status: " + status);
    }

    public void cancelOrder() {
        if (status.equals("Picked Up") || status.equals("Delivered")) {
            System.out.println("Cancellation denied after pickup.");
        } else {
            status = "Cancelled";
            System.out.println(orderId + " status: " + status);
        }
    }

    public void displayOrder() {
        System.out.println(orderId + " | " + customerName + " | Items total: " + calculateItemsTotal() + " | " + status);
    }

    public static int getOrderCount() { return orderCount; }
}