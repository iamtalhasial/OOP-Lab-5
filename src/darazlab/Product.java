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
            this.competitorPrices[i] = (compPrices != null) ? compPrices[i] : 0;
        }
        productCount++;
    }

    public Product(Product other) {
        this.productCode = other.productCode;
        this.title = other.title;
        this.price = other.price;
        this.stock = other.stock;
        this.competitorPrices = other.competitorPrices;
        productCount++;
    }

    public Product(Product other, boolean deep) {
        this.productCode = other.productCode;
        this.title = other.title;
        this.price = other.price;
        this.stock = other.stock;
        if (deep) {
            this.competitorPrices = new double[other.competitorPrices.length];
            for (int i = 0; i < other.competitorPrices.length; i++) {
                this.competitorPrices[i] = other.competitorPrices[i];
            }
        } else {
            this.competitorPrices = other.competitorPrices;
        }
        productCount++;
    }

    public String getProductCode() { return productCode; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
        else System.out.println("Invalid price.");
    }

    public void purchase(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
        } else if (quantity > stock) {
            System.out.println("Insufficient stock.");
        } else {
            stock -= quantity;
            System.out.println("Mouse remaining stock: " + stock);
        }
    }

    public void updateCompetitorPrice(int index, double price) {
        if (index >= 0 && index < 3 && price > 0) {
            competitorPrices[index] = price;
        }
    }

    public double calculateAverageCompetitorPrice() {
        double sum = 0;
        for (double p : competitorPrices) sum += p;
        return sum / 3.0;
    }

    public double priceDifference(Product other) {
        return (other != null) ? Math.abs(this.price - other.price) : 0.0;
    }

    public Product getCheaperProduct(Product other) {
        if (other == null || this.price <= other.price) return this;
        return other;
    }

    public void displayProduct() {
        System.out.println(productCode + " | " + title + " | Price: " + price);
    }

    public static int getProductCount() { return productCount; }
}