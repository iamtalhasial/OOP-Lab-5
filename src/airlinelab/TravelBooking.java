package airlinelab;

public class TravelBooking {
    private final String bookingReference;
    String route;
    private String travelDate;
    private String seatNumber;
    private String status;
    private double[] bagWeights;
    private AirportNotice[] notices;
    private int noticeCount;
    private static int bookingCount = 0;

    public TravelBooking(String ref, String route, String date, String seat, String status, double[] bags) {
        this.bookingReference = ref;
        this.route = route;
        this.travelDate = date;
        this.seatNumber = seat;
        this.status = status;
        this.bagWeights = new double[3];
        for (int i = 0; i < 3; i++) {
            this.bagWeights[i] = (bags != null && bags[i] >= 0) ? bags[i] : 0;
        }
        this.notices = new AirportNotice[3];
        this.noticeCount = 0;
        bookingCount++;
    }

    public void addNotice(AirportNotice notice) {
        if (notice == null) return;
        if (noticeCount >= notices.length) {
            System.out.println("Cannot add notice: capacity reached.");
            return;
        }
        for (int i = 0; i < noticeCount; i++) {
            if (notices[i] == notice) {
                System.out.println("Duplicate notice not allowed.");
                return;
            }
        }
        notices[noticeCount] = notice;
        noticeCount++;
    }

    public void changeSeat(String newSeat) {
        if (status.equals("Checked In")) {
            System.out.println("Seat cannot be changed after check-in.");
        } else {
            this.seatNumber = newSeat;
        }
    }

    public void checkIn() {
        status = "Checked In";
        System.out.println("Check-in successful: " + bookingReference);
    }

    public int getNoticeCount() { return noticeCount; }

    public void displayNotices() {
        System.out.print(bookingReference + " | Notices: " + noticeCount + " | ");
        for (int i = 0; i < noticeCount; i++) {
            System.out.print(notices[i].getNoticeId() + (i < noticeCount - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public static int getBookingCount() { return bookingCount; }
}