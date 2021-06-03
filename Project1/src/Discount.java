public class Discount {
    String shopName;
    String buyerName;
    int discount;
    Discount(String shopName, String buyerName, int discount){
        this.shopName = shopName;
        this.buyerName = buyerName;
        this.discount = discount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public int getDiscount() {
        return discount;
    }

    public String getShopName() {
        return shopName;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "shopName='" + shopName + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", discount=" + discount +
                '}';
    }
}
