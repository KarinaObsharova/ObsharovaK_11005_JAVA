public class Product {
    private String name;
    private int price;
    private String company;

    public Product(String name, int price, String company) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Product: " + name+ " " + price + " " + company;
    }

    public String getName(){
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }
}
