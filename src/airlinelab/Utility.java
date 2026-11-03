package airlinelab;

public class Utility {
    public static void main(String[] args) {
        TravelBooking[] bookings = new TravelBooking[2];
        bookings[0] = new TravelBooking("PK7A21", "Lahore-Istanbul", "2026-11-10", "18A", "Confirmed", new double[]{10, 5, 2});
        bookings[1] = new TravelBooking("PK8B22", "Lahore-Baku", "2026-11-12", "12C", "Confirmed", new double[]{8, 6, 1});

        for (TravelBooking b : bookings) {
            b.displayBooking();
        }

        bookings[0].changeSeat("20B");
        bookings[0].checkIn();
        bookings[0].changeSeat("22C");

        TravelBooking alias = bookings[0];
        System.out.println("Alias seat: " + alias.getSeatNumber());

        System.out.println("Total bookings created: " + TravelBooking.getBookingCount());

        AirportNotice notice = new AirportNotice("N-10", "Gate change", true);
        notice.displayNotice();
    }
}