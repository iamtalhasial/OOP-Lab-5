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
        this.durationHours = new int[3];
        for (int i = 0; i < 3; i++) {
            this.durationHours[i] = (durations[i] >= 0) ? durations[i] : 0;
        }
        this.inside = inside;
        recordsCreated++;
    }

    public String getRegistrationNo() { return registrationNo; }
    public String getOwnerName() { return ownerName; }

    public void recordEntry() {
        inside = true;
        System.out.println("Entry recorded: " + registrationNo);
    }

    public void recordExit() {
        if (inside) {
            inside = false;
            System.out.println("Exit recorded: " + registrationNo);
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
        for (int h : durationHours) {
            sum += h;
        }
        return sum;
    }

    public void displayStatus() {
        System.out.println(registrationNo + " | Owner: " + ownerName + " | Total hours: " + calculateTotalHours());
    }

    public static int getRecordsCreated() { return recordsCreated; }
}