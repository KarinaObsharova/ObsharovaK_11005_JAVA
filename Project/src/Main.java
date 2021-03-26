import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./src/orders.txt");
        Scanner sc = new Scanner(file);
        String text = "";
        while (sc.hasNext()) {
            text = sc.nextLine() + "|";
            String[] str = text.split("\\|");
            String buyerName = str[0];
            String cityName = str[1];
            String orderName = str[2];
            int count = Integer.parseInt(str[3]);

            Order order = new Order(orderName, count);
            City city = new City(cityName, order);
            Buyer buyer = new Buyer(buyerName, city);
            arraySorted(buyer, count, order, city);

        }
        for (int i = 0; i < buyers.size(); i++) {
            System.out.println(buyers.get(i));

        }
        BuyerByCityCountComparator cityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator nameComparator = new BuyerByNameComparator();
        BuyerByOrdersCountComparator ordersCountComparator = new BuyerByOrdersCountComparator();

        TreeSet<Buyer> buyers = new TreeSet<>(nameComparator.thenComparing(cityCountComparator).thenComparing(ordersCountComparator));
        TreeSet<Buyer> buyers1 = new TreeSet<>(ordersCountComparator.thenComparing(cityCountComparator).thenComparing(nameComparator));
        writeOrderToFile(buyers, buyers1);

    }

    public static void writeOrderToFile(TreeSet<Buyer> buyers, TreeSet<Buyer> buyers1) {
        try (FileOutputStream fos = new FileOutputStream("./src/sortedByName.txt");
             ObjectOutputStream out = new ObjectOutputStream(fos);
             FileOutputStream fos1 = new FileOutputStream("./src/sortedByOrders.txt");
             ObjectOutputStream out1 = new ObjectOutputStream(fos1)) {
            out.writeObject(buyers);
            out1.writeObject(buyers1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void arraySorted(Buyer buyer, int count, Order order, City city) {
        if (buyers.size() == 0) {
            buyers.add(buyer);
        } else {
            int idBuyer = checkBuyer(buyer.name);
            if (idBuyer != -1) {
                int idCity = checkCity(buyers.get(idBuyer).cities, city.nameCity);
                if (idCity != -1) {
                    int idOrder = checkOrder(buyers.get(idBuyer).cities.get(idCity).orders, order.name);
                    if (idOrder != -1) {
                        buyers.get(idBuyer).cities.get(idCity).orders.get(idOrder).count += count;

                    } else buyers.get(idBuyer).cities.get(idCity).orders.add(order);

                } else buyers.get(idBuyer).cities.add(city);

            } else {
                buyers.add(buyer);
            }

        }
    }


    static int checkBuyer(String name) {
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).name.equals(name))
                return i;
        }
        return -1;
    }

    static int checkCity(ArrayList<City> cities, String name) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).nameCity.equals(name))
                return i;
        }
        return -1;
    }

    static int checkOrder(ArrayList<Order> orders, String name) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).name.equals(name))
                return i;
        }
        return -1;
    }
}


























        /*Buyer buyer = new Buyer();
        Map<String, Map<String, Map<String, Integer>>> map = new HashMap<>();
        File file = new File("./src/orders.txt");
        Scanner sc = new Scanner(file);
        String text = "";
        while (sc.hasNext()) {
            text = sc.nextLine() + "|";
            String[] text1 = text.split("\\|");
            if (map.containsKey(text1[0])) { // если имя совпало
                Map<String, Map<String, Integer>> tempCity = map.get(text1[0]);
                if (tempCity.containsKey(text1[1])) { // если город
                    Map<String, Integer> tempOrder = tempCity.get(text1[1]);
                    if (tempOrder.containsKey(text1[2])) { // если заказ
                        tempOrder.put(text1[2], tempOrder.get(text1[2]) + Integer.parseInt(text1[3]));
                    } else {
                        tempOrder.put(text1[2], Integer.parseInt(text1[3]));
                    }
                    tempCity.put(text1[1], tempOrder);
                } else {
                    Map<String, Integer> tempOrder2 = new HashMap<>();
                    tempOrder2.put(text1[2], Integer.parseInt(text1[3]));
                    tempCity.put(text1[1], tempOrder2);
                }
            } else {
                Map<String, Integer> tempOrder = new HashMap<>();
                Map<String, Map<String, Integer>> tempCity2 = new HashMap<>();
                tempOrder.put(text1[2], Integer.parseInt(text1[3]));
                tempCity2.put(text1[1], tempOrder);
                map.put(text1[0], tempCity2);
            }

                for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : map.entrySet()) {
                    for (Map.Entry<String, Map<String, Integer>> entry1 : map.get(text1[0]).entrySet()) {
                        for (Map.Entry<String, Integer> entry2 : map.get(text1[1]).get(text1[2]).entrySet()) {
                            buyer.setName(entry.toString());
                            buyer.setCity((City) entry1);
                        }
                    }
                }


        }

            System.out.println(map);


*/









