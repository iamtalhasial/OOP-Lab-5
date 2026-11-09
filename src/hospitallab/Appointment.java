package hospitallab;

public class Appointment {
    private final String appointmentId;
    private String patientName;
    private String date;
    private String time;
    private String status;
    private ClinicRoom assignedRoom;

    public Appointment(String id, String patientName, String date, String time) {
        this.appointmentId = id;
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.status = "Scheduled";
        this.assignedRoom = null;
    }

    public void assignRoom(ClinicRoom room) {
        this.assignedRoom = room;
    }

    public void checkIn() {
        if (status.equals("Cancelled")) {
            System.out.println("Check-in denied: appointment cancelled.");
            return;
        }
        if (assignedRoom != null && assignedRoom.admitPatient()) {
            status = "Checked In";
        } else {
            System.out.println("Check-in denied: Room capacity full or unassigned.");
        }
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public void displayAppointment() {
        String rNo = (assignedRoom != null) ? assignedRoom.getRoomNo() : "None";
        System.out.println(appointmentId + " | " + status + " | Room: " + rNo);
    }
}