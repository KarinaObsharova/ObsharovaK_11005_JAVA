import Task3.Sklad;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Task1
        TreeSet<String> treeSet = new TreeSet<>(
                (a, b) -> Integer.compare(a.length(), b.length())
        );
        treeSet.add("Kahhhhhhhhhhhhhhh");
        treeSet.add("Kiryannnnn");
        System.out.println(treeSet);

        // Task 2
        List<Integer> arrayList = Arrays.asList(5, 6, 8, 4, 10, 45, 17);
        ArrayList<Integer> result = sort(arrayList, x ->  x % 2 == 0);
        System.out.println(result);

        // Task3
//        Sklad.addListeners(()-> {
//            Map<String, Integer> orders = finalOrder;
//            int max = 0;
//            int sum = 0;
//            for (Map.Entry<String, Integer> map: orders.entrySet()){
//                System.out.println(map.getKey() + " " + map.getValue());
//                sum += map.getValue();
//                if (map.getValue()> max){
//                    max = map.getValue();
//                }
//            }
//            System.out.println("max - " + max);
//            System.out.println("sum - " + sum);
//        });

    }
    public static ArrayList<Integer> sort(List<Integer> arrayList,
                                          Predicate<Integer> predicate){
        ArrayList<Integer> result = new ArrayList<>();
        for(int x: arrayList){
            if(predicate.test(x)){
                result.add(x);
            }
        }
        return result;
    }
}
