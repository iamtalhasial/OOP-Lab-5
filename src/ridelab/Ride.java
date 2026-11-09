package ridelab;

public class Ride {
    private final String rideId;
    private String pickup;
    private String destination;
    private double estimatedFare;
    private String status;

    public Ride(String rideId, String pickup, String destination, double estimatedFare) {
        this.rideId = rideId;
        this.pickup = pickup;
        this.destination = destination;
        this.estimatedFare = (estimatedFare >= 0) ? estimatedFare : 0;
        this.status = "Created";
    }

    public String getRideId() { return rideId; }
    public double getEstimatedFare() { return estimatedFare; }

    public void startRide() {
        status = "In Progress";
    }

    public void completeRide(double finalFare) {
        if (!status.equals("In Progress")) {
            System.out.println("Cannot complete ride before it starts.");
        } else if (finalFare <= 0) {
            System.out.println("Invalid fare.");
        } else {
            status = "Completed";
            estimatedFare = finalFare;
            System.out.println(rideId + " | " + status + " | Final fare: " + estimatedFare);
        }
    }

    public void displayRide() {
        System.out.println(rideId + " | " + pickup + " to " + destination + " | " + estimatedFare);
    }
}