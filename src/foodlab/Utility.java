package foodlab;

public class Utility {
    public static void main(String[] args) {
        FoodOrder[] orders = new FoodOrder[2];
        orders[0] = new FoodOrder("ORD-501", "Hamza", "Johar Town", new double[]{500, 650, 300}, "Preparing");
        orders[1] = new FoodOrder("ORD-502", "Ayesha", "Model Town", new double[]{300, 350, 250}, "Preparing");

        for (FoodOrder o : orders) {
            o.displayOrder();
        }

        orders[0].advanceStatus();
        FoodOrder alias = orders[0];
        alias.advanceStatus();
        orders[0].cancelOrder();

        orders[1].cancelOrder();

        System.out.println("Order objects created: " + FoodOrder.getOrderCount());

        RestaurantOffer offer = new RestaurantOffer("OFF-1", "Weekend Deal", 10.0);
        offer.displayOffer();
    }
}