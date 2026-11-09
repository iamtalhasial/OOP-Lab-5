package foodlab;

public class RestaurantOffer {
    private final String offerId;
    private String description;
    private double discountPercent;
    private boolean assigned;

    public RestaurantOffer(String offerId, String description, double discountPercent) {
        this.offerId = offerId;
        this.description = description;
        setDiscountPercent(discountPercent);
        this.assigned = false;
    }

    public String getOfferId() { return offerId; }
    public String getDescription() { return description; }
    public double getDiscountPercent() { return discountPercent; }
    public boolean isAssigned() { return assigned; }

    public void setDiscountPercent(double discount) {
        if (discount >= 0 && discount <= 100) {
            this.discountPercent = discount;
        } else {
            System.out.println("Invalid discount percentage.");
        }
    }

    public void markAssigned() { this.assigned = true; }
    public void displayOffer() {
        System.out.println(offerId + " | " + description + " | Discount: " + discountPercent + "%");
    }
}