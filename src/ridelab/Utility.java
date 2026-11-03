package ridelab;

public class Utility {
    public static void main(String[] args) {
        Ride[] rides = new Ride[2];
        rides[0] = new Ride("R-908", "UCP", "Gulberg", 720.0, new int[]{5, 12, 8}, "Driver Arriving");
        rides[1] = new Ride("R-909", "UCP", "Johar Town", 500.0, new int[]{3, 10, 7}, "Driver Arriving");

        for (Ride r : rides) {
            r.displayRide();
        }

        rides[1].completeRide(500.0);

        Ride alias = rides[0];
        alias.startRide();
        rides[0].completeRide(750.0);

        System.out.println("Total rides created: " + Ride.getRideCount());

        DriverRating rating = new DriverRating("DR-1", 5, "Smooth journey");
        rating.displayRating();
    }
}