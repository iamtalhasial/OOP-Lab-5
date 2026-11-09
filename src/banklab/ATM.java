package banklab;

public class ATM {
    private final String machineId;
    private String location;
    private boolean working;

    public ATM(String machineId, String location, boolean working) {
        this.machineId = machineId;
        this.location = location;
        this.working = working;
    }

    public void setWorking(boolean working) { this.working = working; }
    public void displayATM() {
        System.out.println(machineId + " | " + location + " | Working: " + working);
    }
}