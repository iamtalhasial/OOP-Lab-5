package parkinglab;

public class VisitorPass {
    private final String passId;
    private String visitorName;
    private boolean active;

    public VisitorPass(String passId, String visitorName, boolean active) {
        this.passId = passId;
        this.visitorName = visitorName;
        this.active = active;
    }

    public void activate() { active = true; }
    public void deactivate() { active = false; }
    public void displayPass() {
        System.out.println(passId + " | " + visitorName + " | Active: " + active);
    }
}