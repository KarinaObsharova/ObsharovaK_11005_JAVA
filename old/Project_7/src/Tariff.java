public class Tariff {
    private String name;
    private int cost;

    Tariff(String name, int cost) {

        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + " " + cost + "руб.";
    }
    public int getCost(){
        return cost;
    }
}
