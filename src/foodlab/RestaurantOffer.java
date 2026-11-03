package foodlab;

public class RestaurantOffer {
    private final String offerId;
    private String description;
    private double discountPercent;

    public RestaurantOffer(String offerId, String description, double discountPercent) {
        this.offerId = offerId;
        this.description = description;
        setDiscountPercent(discountPercent);
    }

    public void setDiscountPercent(double discount) {
        if (discount >= 0 && discount <= 100) {
            this.discountPercent = discount;
        } else {
            System.out.println("Invalid discount percentage.");
        }
    }

    public void displayOffer() {
        System.out.println(offerId + " | " + description + " | Discount: " + discountPercent + "%");
    }
}