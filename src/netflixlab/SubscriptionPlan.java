package netflixlab;

public class SubscriptionPlan {
    private final String planCode;
    private String planName;
    private double monthlyFee;

    public SubscriptionPlan(String planCode, String planName, double monthlyFee) {
        this.planCode = planCode;
        this.planName = planName;
        setMonthlyFee(monthlyFee);
    }

    public void setMonthlyFee(double fee) {
        if (fee > 0) {
            this.monthlyFee = fee;
        } else {
            System.out.println("Invalid monthly fee.");
        }
    }

    public void displayPlan() {
        System.out.println(planCode + " | " + planName + " | Monthly fee: " + monthlyFee);
    }
}