package ridelab;

public class Driver {
    private final String driverId;
    private String driverName;
    private Ride[] assignedRides;
    private int rideCount;

    public Driver(String driverId, String driverName) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.assignedRides = new Ride[3];
        this.rideCount = 0;
    }

    public void addRide(Ride ride) {
        if (ride == null) return;
        if (rideCount >= assignedRides.length) {
            System.out.println("Cannot assign ride: driver full.");
            return;
        }
        for (int i = 0; i < rideCount; i++) {
            if (assignedRides[i] == ride) {
                System.out.println("Duplicate ride not allowed.");
                return;
            }
        }
        assignedRides[rideCount] = ride;
        rideCount++;
    }

    public double calculateAssignedFare() {
        double total = 0;
        for (int i = 0; i < rideCount; i++) {
            total += assignedRides[i].getEstimatedFare();
        }
        return total;
    }

    public int getRideCount() { return rideCount; }

    public void displayRides() {
        System.out.println(driverId + " | Driver: " + driverName + " | Assigned rides: " + rideCount);
    }
}