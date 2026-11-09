package parkinglab;

public class ParkingRecord {
    private final String registrationNo;
    private String ownerName;
    private int[] durationHours;
    private boolean inside;
    private static int recordsCreated = 0;

    public ParkingRecord(String regNo, String ownerName, int[] durations, boolean inside) {
        this.registrationNo = regNo;
        this.ownerName = ownerName;
        this.inside = inside;
        this.durationHours = new int[3];
        for (int i = 0; i < 3; i++) {
            this.durationHours[i] = (durations != null && durations[i] >= 0) ? durations[i] : 0;
        }
        recordsCreated++;
    }

    public ParkingRecord(ParkingRecord other) {
        this.registrationNo = other.registrationNo;
        this.ownerName = other.ownerName;
        this.inside = other.inside;
        this.durationHours = other.durationHours;
        recordsCreated++;
    }

    public ParkingRecord(ParkingRecord other, boolean deep) {
        this.registrationNo = other.registrationNo;
        this.ownerName = other.ownerName;
        this.inside = other.inside;
        if (deep) {
            this.durationHours = new int[other.durationHours.length];
            for (int i = 0; i < other.durationHours.length; i++) {
                this.durationHours[i] = other.durationHours[i];
            }
        } else {
            this.durationHours = other.durationHours;
        }
        recordsCreated++;
    }

    public String getRegistrationNo() { return registrationNo; }
    public String getOwnerName() { return ownerName; }

    public void recordEntry() { this.inside = true; }
    public void recordExit() {
        if (inside) {
            inside = false;
            System.out.println(registrationNo + " entry and exit recorded.");
        } else {
            System.out.println("Exit denied: vehicle is not inside.");
        }
    }

    public void updateDuration(int index, int hours) {
        if (index >= 0 && index < 3 && hours >= 0) {
            durationHours[index] = hours;
        } else {
            System.out.println("Invalid duration or index.");
        }
    }

    public int calculateTotalHours() {
        int sum = 0;
        for (int h : durationHours) sum += h;
        return sum;
    }

    public boolean isLongerThan(ParkingRecord other) {
        return other != null && this.calculateTotalHours() > other.calculateTotalHours();
    }

    public ParkingRecord getLongerRecord(ParkingRecord other) {
        if (other == null || this.calculateTotalHours() >= other.calculateTotalHours()) return this;
        return other;
    }

    public void displayStatus() {
        System.out.println(registrationNo + " | Owner: " + ownerName + " | Total hours: " + calculateTotalHours());
    }

    public static int getRecordsCreated() { return recordsCreated; }
}