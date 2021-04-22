import java.io.Serializable;
import java.util.ArrayList;

public class Buyer {
    String name;
    ArrayList<City> cities = new ArrayList<>();

    public Buyer(String name, City city ){
        this.name = name;
        cities.add(city);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                 name + '\'' +
                 cities +
                '}';
    }
}
