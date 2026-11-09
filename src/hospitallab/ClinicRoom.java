package hospitallab;

public class ClinicRoom {
    private final String roomNo;
    private int capacity;
    private int occupied;
    private static int roomCount = 0;

    public ClinicRoom(String roomNo, int capacity) {
        this.roomNo = roomNo;
        this.capacity = (capacity > 0) ? capacity : 1;
        this.occupied = 0;
        roomCount++;
    }

    public String getRoomNo() { return roomNo; }

    public boolean admitPatient() {
        if (occupied < capacity) {
            occupied++;
            return true;
        }
        return false;
    }

    public void releasePatient() {
        if (occupied > 0) occupied--;
    }

    public void displayRoom() {
        System.out.println(roomNo + " | Occupied: " + occupied + "/" + capacity);
    }

    public static int getRoomCount() { return roomCount; }
}