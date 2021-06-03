public class Buyer {
    String name;
    String city;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    Buyer(String name, String city){
        this.name = name;
        this.city = city;
    }


    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
