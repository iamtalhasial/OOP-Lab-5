package darazlab;

public class Product {
    private final String productCode;
    private String title;
    private double price;
    private int stock;
    private double[] competitorPrices;
    private static int productCount = 0;

    public Product(String code, String title, double price, int stock, double[] compPrices) {
        this.productCode = code;
        this.title = title;
        this.price = (price > 0) ? price : 0;
        this.stock = (stock >= 0) ? stock : 0;
        this.competitorPrices = new double[3];
        for (int i = 0; i < 3; i++) {
            this.competitorPrices[i] = compPrices[i];
        }
        productCount++;
    }

    public String getProductCode() { return productCode; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price.");
        }
    }

    public boolean isAvailable() { return stock > 0; }

    public void purchase(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
        } else if (quantity > stock) {
            System.out.println("Insufficient stock.");
        } else {
            stock -= quantity;
            System.out.println("Purchase completed. Remaining stock: " + stock);
        }
    }

    public double calculateAverageCompetitorPrice() {
        double sum = 0;
        for (double p : competitorPrices) {
            sum += p;
        }
        return sum / 3.0;
    }

    public void displayProduct() {
        System.out.println(productCode + " | " + title + " | Price: " + price + " | Stock: " + stock + " | Avg competitor: " + calculateAverageCompetitorPrice());
    }

    public static int getProductCount() { return productCount; }
}