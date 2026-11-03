package hospitallab;

public class ClinicRoom {
    private final String roomNo;
    private int capacity;
    private int occupied;

    public ClinicRoom(String roomNo, int capacity) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.occupied = 0;
    }

    public void checkInVisitor() {
        if (occupied < capacity) {
            occupied++;
        } else {
            System.out.println("Clinic room is at full capacity.");
        }
    }

    public void displayRoom() {
        System.out.println(roomNo + " | Occupied: " + occupied + "/" + capacity);
    }
}