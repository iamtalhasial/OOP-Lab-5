package darazlab;

public class Utility {
    public static void main(String[] args) {
        Product mouse = new Product("WM-510", "Mouse", 2499.0, 18, new double[]{2500, 2400, 2600});
        Product keyboard = new Product("KB-220", "Keyboard", 3499.0, 6, new double[]{3400, 3500, 3600});

        Product shallow = new Product(mouse);
        Product deep = new Product(mouse, true);

        mouse.updateCompetitorPrice(0, 2800);

        System.out.println("Mouse competitor average: " + mouse.calculateAverageCompetitorPrice());
        System.out.println("Shallow: " + shallow.calculateAverageCompetitorPrice() + " | Deep: " + deep.calculateAverageCompetitorPrice());

        Product cheaper = mouse.getCheaperProduct(keyboard);
        System.out.println("Cheaper product: " + cheaper.getProductCode() + " | Difference: " + mouse.priceDifference(keyboard));

        mouse.purchase(2);
        keyboard.purchase(30); // Oversell test

        System.out.println("Product objects: " + Product.getProductCount());

        SellerNotice notice = new SellerNotice("N-1", "Eid Sale", true);
        notice.displayNotice();
    }
}