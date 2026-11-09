package airlinelab;

public class Utility {
    public static void main(String[] args) {
        TravelBooking b1 = new TravelBooking("PK7A21", "Lahore-Istanbul", "2026-11-10", "18A", "Confirmed", new double[]{10, 5, 2});
        TravelBooking b2 = new TravelBooking("PK8B22", "Lahore-Baku", "2026-11-12", "12C", "Confirmed", new double[]{8, 6, 1});

        AirportNotice n10 = new AirportNotice("N-10", "Gate change", true);
        AirportNotice n11 = new AirportNotice("N-11", "Security Reminder", true);

        b1.addNotice(n10);
        b1.addNotice(n11);
        b2.addNotice(n10); // Many-to-many link

        b1.displayNotices();
        b2.displayNotices();

        b1.addNotice(n10); // Duplicate test

        b1.checkIn();
        b1.changeSeat("22C"); // Rejected test

        System.out.println("AirportNotice objects created: " + AirportNotice.getNoticeCount());
    }
}