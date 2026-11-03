package ridelab;

public class Ride {
    private final String rideId;
    private String pickup;
    private String destination;
    private double estimatedFare;
    private int[] stageMinutes;
    private String status;
    private static int rideCount = 0;

    public Ride(String rideId, String pickup, String destination, double estimatedFare, int[] stages, String status) {
        this.rideId = rideId;
        this.pickup = pickup;
        this.destination = destination;
        this.estimatedFare = (estimatedFare >= 0) ? estimatedFare : 0;
        this.stageMinutes = new int[3];
        for (int i = 0; i < 3; i++) {
            this.stageMinutes[i] = stages[i];
        }
        this.status = status;
        rideCount++;
    }

    public String getRideId() { return rideId; }
    public String getStatus() { return status; }

    public void startRide() {
        status = "In Progress";
        System.out.println(rideId + " status: " + status);
    }

    public void completeRide(double finalFare) {
        if (!status.equals("In Progress")) {
            System.out.println("Cannot complete ride before it starts.");
        } else if (finalFare < 0) {
            System.out.println("Invalid fare.");
        } else {
            status = "Completed";
            estimatedFare = finalFare;
            System.out.println(rideId + " status: " + status + " | Final fare: " + estimatedFare);
        }
    }

    public int calculateTotalTravelMinutes() {
        int sum = 0;
        for (int m : stageMinutes) {
            sum += m;
        }
        return sum;
    }

    public void displayRide() {
        System.out.println(rideId + " | " + pickup + " to " + destination + " | Minutes: " + calculateTotalTravelMinutes() + " | " + status);
    }

    public static int getRideCount() { return rideCount; }
}