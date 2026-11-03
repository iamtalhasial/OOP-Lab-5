package librarylab;

public class ReadingRoom {
    private final String roomId;
    private int capacity;
    private int occupied;

    public ReadingRoom(String roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.occupied = 0;
    }

    public void occupySeat() {
        if (occupied < capacity) {
            occupied++;
        } else {
            System.out.println("Room is full.");
        }
    }

    public void freeSeat() {
        if (occupied > 0) {
            occupied--;
        }
    }

    public void displayRoom() {
        System.out.println(roomId + " | Occupied: " + occupied + "/" + capacity);
    }
}