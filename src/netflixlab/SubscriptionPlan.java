package netflixlab;

public class SubscriptionPlan {
    private final String planCode;
    private String planName;
    private double monthlyFee;
    private static int planCount = 0;

    public SubscriptionPlan(String planCode, String planName, double monthlyFee) {
        this.planCode = planCode;
        this.planName = planName;
        setMonthlyFee(monthlyFee);
        planCount++;
    }

    public String getPlanName() { return planName; }

    public void setMonthlyFee(double fee) {
        if (fee > 0) this.monthlyFee = fee;
        else System.out.println("Invalid monthly fee.");
    }

    public void displayPlan() {
        System.out.println(planCode + " | " + planName + " | Fee: " + monthlyFee);
    }

    public static int getPlanCount() { return planCount; }
}