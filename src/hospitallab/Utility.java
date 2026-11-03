package hospitallab;

public class Utility {
    public static void main(String[] args) {
        Appointment[] appointments = new Appointment[2];
        appointments[0] = new Appointment("AP-317", "Bilal", "Monday", "10:30 AM", "Scheduled", new int[]{10, 15, 20});
        appointments[1] = new Appointment("AP-318", "Zainab", "Tuesday", "11:00 AM", "Scheduled", new int[]{5, 10, 15});

        for (Appointment app : appointments) {
            app.displayAppointment();
        }

        Appointment alias = appointments[0];
        alias.reschedule("Monday", "11:30 AM");

        appointments[1].cancel();
        appointments[1].checkIn();

        System.out.println("Appointments created: " + Appointment.getAppointmentCount());

        ClinicRoom room = new ClinicRoom("C-12", 2);
        room.checkInVisitor();
        room.displayRoom();
    }
}