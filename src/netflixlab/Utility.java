package netflixlab;

public class Utility {
    public static void main(String[] args) {
        SubscriptionPlan standardPlan = new SubscriptionPlan("P-1", "Standard", 1200.0);

        ViewingRecord v1 = new ViewingRecord("M-101", "Interstellar", 169);
        ViewingRecord v2 = new ViewingRecord("M-102", "Inception", 148);

        v1.setPlan(standardPlan);
        v2.setPlan(standardPlan);

        v1.pauseAt(42);
        v2.pauseAt(300); // Invalid pause position test

        v1.displayDetails();
        v2.displayDetails();

        System.out.println("SubscriptionPlan objects created: " + SubscriptionPlan.getPlanCount());
    }
}