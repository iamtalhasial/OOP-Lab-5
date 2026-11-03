package ridelab;

public class DriverRating {
    private final String ratingId;
    private int stars;
    private String comment;

    public DriverRating(String ratingId, int stars, String comment) {
        this.ratingId = ratingId;
        setStars(stars);
        this.comment = comment;
    }

    public void setStars(int stars) {
        if (stars >= 1 && stars <= 5) {
            this.stars = stars;
        } else {
            System.out.println("Invalid star rating.");
        }
    }

    public void displayRating() {
        System.out.println(ratingId + " | Stars: " + stars);
    }
}