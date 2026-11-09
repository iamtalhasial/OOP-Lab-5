package netflixlab;

public class ViewingRecord {
    private final String viewingId;
    private String title;
    private int durationMinutes;
    private int progressMinutes;
    private SubscriptionPlan plan;

    public ViewingRecord(String viewingId, String title, int durationMinutes) {
        this.viewingId = viewingId;
        this.title = title;
        this.durationMinutes = (durationMinutes > 0) ? durationMinutes : 120;
        this.progressMinutes = 0;
        this.plan = null;
    }

    public void setPlan(SubscriptionPlan plan) {
        this.plan = plan;
    }

    public void pauseAt(int minutes) {
        if (minutes >= 0 && minutes <= durationMinutes) {
            progressMinutes = minutes;
        } else {
            System.out.println("Invalid viewing position.");
        }
    }

    public void resume() {}

    public int calculateRemainingMinutes() {
        return durationMinutes - progressMinutes;
    }

    public void displayDetails() {
        String pName = (plan != null) ? plan.getPlanName() : "None";
        System.out.println(title + " | Remaining: " + calculateRemainingMinutes() + " | Plan: " + pName);
    }
}