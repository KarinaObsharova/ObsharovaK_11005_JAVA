import java.util.ArrayList;

public class City {
    String nameCity;
    ArrayList<Order> orders = new ArrayList<>();

    public City(String nameCity, Order order){
        this.nameCity = nameCity;
        orders.add(order);

    }

    @Override
    public String toString() {
        return "City{" +
                 nameCity + '\'' +
                 orders +
                '}';
    }
}
