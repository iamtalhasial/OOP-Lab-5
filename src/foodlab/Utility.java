package foodlab;

public class Utility {
    public static void main(String[] args) {
        FoodOrder ord1 = new FoodOrder("ORD-501", "Hamza", "Johar Town", new double[]{500, 650, 300}, "Preparing");
        FoodOrder ord2 = new FoodOrder("ORD-502", "Ayesha", "Model Town", new double[]{300, 350, 250}, "Preparing");

        RestaurantOffer off1 = new RestaurantOffer("OFF-1", "Hamza Exclusive", 10.0);
        RestaurantOffer off2 = new RestaurantOffer("OFF-2", "Ayesha Special", 20.0);

        ord1.assignOffer(off1);
        ord2.assignOffer(off2);

        ord1.displayOrder();
        ord2.displayOrder();

        ord2.assignOffer(off1); // Rejected assignment

        System.out.println("FoodOrder objects: " + FoodOrder.getOrderCount());
    }
}