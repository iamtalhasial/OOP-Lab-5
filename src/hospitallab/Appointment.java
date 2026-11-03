package hospitallab;

public class Appointment {
    private final String appointmentId;
    private String patientName;
    private String date;
    private String time;
    private String status;
    private int[] waitingTimes;
    private static int appointmentCount = 0;

    public Appointment(String id, String patientName, String date, String time, String status, int[] waits) {
        this.appointmentId = id;
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.status = status;
        this.waitingTimes = new int[3];
        for (int i = 0; i < 3; i++) {
            this.waitingTimes[i] = waits[i];
        }
        appointmentCount++;
    }

    public void reschedule(String newDate, String newTime) {
        if (status.equals("Cancelled")) {
            System.out.println("Reschedule denied: appointment cancelled.");
        } else {
            this.date = newDate;
            this.time = newTime;
            System.out.println(appointmentId + " rescheduled: " + date + " " + time);
        }
    }

    public void checkIn() {
        if (status.equals("Cancelled")) {
            System.out.println("Check-in denied: appointment cancelled.");
        } else {
            status = "Checked In";
            System.out.println(appointmentId + " checked in.");
        }
    }

    public void cancel() {
        status = "Cancelled";
        System.out.println(appointmentId + " cancelled.");
    }

    public double calculateAverageWait() {
        int sum = 0;
        for (int w : waitingTimes) {
            sum += w;
        }
        return sum / 3.0;
    }

    public void displayAppointment() {
        System.out.println(appointmentId + " | " + date + " " + time + " | " + status + " | Avg wait: " + calculateAverageWait());
    }

    public static int getAppointmentCount() { return appointmentCount; }
}