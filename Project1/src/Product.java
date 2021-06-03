public class Product {
    String shopName;
    String productName;
    int price;

    public String getShopName() {
        return shopName;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    Product(String shopName, String productName, int price){
        this.shopName = shopName;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "shopName='" + shopName + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
