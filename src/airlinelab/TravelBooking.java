package airlinelab;

public class TravelBooking {
    private final String bookingReference;
    String route;
    private String travelDate;
    private String seatNumber;
    private String status;
    private double[] bagWeights;
    private static int bookingCount = 0;

    public TravelBooking(String ref, String route, String date, String seat, String status, double[] bags) {
        this.bookingReference = ref;
        this.route = route;
        this.travelDate = date;
        this.seatNumber = seat;
        this.status = status;
        this.bagWeights = new double[3];
        for (int i = 0; i < 3; i++) {
            this.bagWeights[i] = (bags[i] >= 0) ? bags[i] : 0;
        }
        bookingCount++;
    }

    public String getBookingReference() { return bookingReference; }
    public String getSeatNumber() { return seatNumber; }

    public void changeSeat(String newSeat) {
        if (status.equals("Checked In")) {
            System.out.println("Seat cannot be changed after check-in.");
        } else {
            this.seatNumber = newSeat;
            System.out.println("Seat changed to " + newSeat + ".");
        }
    }

    public void checkIn() {
        status = "Checked In";
        System.out.println("Check-in successful.");
    }

    public double calculateTotalBaggageWeight() {
        double sum = 0;
        for (double w : bagWeights) {
            sum += w;
        }
        return sum;
    }

    public void displayBooking() {
        System.out.println(bookingReference + " | " + route + " | Seat: " + seatNumber + " | " + status + " | Baggage: " + calculateTotalBaggageWeight() + " kg");
    }

    public static int getBookingCount() { return bookingCount; }
}