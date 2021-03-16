import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> mapProduct = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = sc.next();
            String nameOrder = sc.next();
            int quantity = sc.nextInt();
            if (map.containsKey(name)) {
                if (map.get(name).containsKey(nameOrder)) {
                    Map<String, Integer> temp = map.get(name);
                    temp.put(nameOrder, map.get(name).get(nameOrder) + quantity);
                    map.put(name, temp);
                    System.out.println(map);
                } else {
                    Map<String, Integer> temp = map.get(name);
                    temp.put(nameOrder, quantity);
                    map.put(name, temp);
                    System.out.println(map);
                }
            } else {
                Map<String,Integer> temp = new HashMap<>();
                temp.put(nameOrder, quantity);
                map.put(name, temp);
                System.out.println(map);
            }

        }
    }
}
