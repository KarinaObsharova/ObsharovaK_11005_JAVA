public class Order {
    String nameBuyer;
    String shopName;
    String productName;
    int price;
    int discount;

    public Order(String nameBuyer, String shopName, String productName, int price, int discount) {
        this.nameBuyer = nameBuyer;
        this.shopName = shopName;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
    }

    public Order(String nameBuyer, String shopName, String productName, int price) {
        this.nameBuyer = nameBuyer;
        this.shopName = shopName;
        this.productName = productName;
        this.price = price;
    }

    public Order(String nameBuyer, String shopName, int discount) {
        this.nameBuyer = nameBuyer;
        this.discount = discount;
        this.shopName = shopName;

    }


    @Override
    public String toString() {
        return nameBuyer + " " + shopName + " " + discount;
    }

}

