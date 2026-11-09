package ridelab;

public class Utility {
    public static void main(String[] args) {
        Ride r1 = new Ride("R-908", "UCP", "Gulberg", 720.0);
        Ride r2 = new Ride("R-909", "UCP", "Johar Town", 500.0);

        Driver driver = new Driver("D-10", "Mr. Kamran");
        driver.addRide(r1);
        driver.addRide(r2);

        driver.displayRides();
        System.out.println("Combined estimated fare: " + driver.calculateAssignedFare());

        driver.addRide(r1); // Duplicate attempt

        r2.completeRide(500.0); // Rejected before start
        r1.startRide();
        r1.completeRide(750.0);
    }
}