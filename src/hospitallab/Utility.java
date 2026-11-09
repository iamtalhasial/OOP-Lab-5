package hospitallab;

public class Utility {
    public static void main(String[] args) {
        ClinicRoom roomC12 = new ClinicRoom("C-12", 2);

        Appointment ap1 = new Appointment("AP-317", "Bilal", "Monday", "10:30 AM");
        Appointment ap2 = new Appointment("AP-318", "Zainab", "Tuesday", "11:00 AM");

        ap1.assignRoom(roomC12);
        ap2.assignRoom(roomC12);

        ap1.checkIn();
        ap2.cancel();
        ap2.checkIn(); // Denied test

        ap1.displayAppointment();
        ap2.displayAppointment();

        roomC12.displayRoom();
        System.out.println("ClinicRoom objects created: " + ClinicRoom.getRoomCount());
    }
}