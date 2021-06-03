public class Purchase {
    String buyerName;
    String shopName;
    String productName;

    public String getBuyerName() {
        return buyerName;
    }

    public String getShopName() {
        return shopName;
    }

    public String getProductName() {
        return productName;
    }

    Purchase(String buyerName, String shopName, String productName){
        this.buyerName = buyerName;
        this.shopName = shopName;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyerName='" + buyerName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
