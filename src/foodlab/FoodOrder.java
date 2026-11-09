package foodlab;

public class FoodOrder {
    private final String orderId;
    private String customerName;
    private String address;
    private double[] itemPrices;
    private String status;
    private RestaurantOffer offer;
    private static int orderCount = 0;

    public FoodOrder(String orderId, String customerName, String address, double[] prices, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
        this.itemPrices = new double[3];
        for (int i = 0; i < 3; i++) {
            this.itemPrices[i] = (prices != null && prices[i] >= 0) ? prices[i] : 0;
        }
        this.status = status;
        this.offer = null;
        orderCount++;
    }

    public double calculateItemsTotal() {
        double sum = 0;
        for (double p : itemPrices) sum += p;
        return sum;
    }

    public double calculatePayableTotal() {
        double total = calculateItemsTotal();
        if (offer != null) {
            total -= total * (offer.getDiscountPercent() / 100.0);
        }
        return total;
    }

    public void assignOffer(RestaurantOffer offer) {
        if (this.offer != null) {
            System.out.println("Offer assignment denied: order already has an offer.");
            return;
        }
        if (offer == null || offer.isAssigned()) {
            System.out.println("Offer assignment denied: already assigned.");
            return;
        }
        this.offer = offer;
        offer.markAssigned();
    }

    public void cancelOrder() {
        if (status.equals("Picked Up") || status.equals("Delivered")) {
            System.out.println("Cancellation denied after pickup.");
        } else {
            status = "Cancelled";
        }
    }

    public RestaurantOffer getOffer() { return offer; }
    public static int getOrderCount() { return orderCount; }

    public void displayOrder() {
        String offerStr = (offer != null) ? offer.getOfferId() : "None";
        System.out.println(orderId + " | Offer: " + offerStr + " | Payable: " + calculatePayableTotal());
    }
}