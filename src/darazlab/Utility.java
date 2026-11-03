package darazlab;

public class Utility {
    public static void main(String[] args) {
        Product[] products = new Product[2];
        products[0] = new Product("WM-510", "Mouse", 2499.0, 18, new double[]{2500, 2400, 2600});
        products[1] = new Product("KB-220", "Keyboard", 3499.0, 6, new double[]{3400, 3500, 3600});

        for (Product p : products) {
            p.displayProduct();
        }

        products[0].purchase(2);
        products[1].purchase(30);

        Product alias = products[0];
        alias.setPrice(2399.0);
        System.out.println("Updated via alias | " + products[0].getProductCode() + " | Price: " + products[0].getPrice());

        System.out.println("Product objects created: " + Product.getProductCount());

        SellerNotice notice = new SellerNotice("N-1", "Eid Sale", true);
        notice.displayNotice();
    }
}