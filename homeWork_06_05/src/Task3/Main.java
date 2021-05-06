package Task3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("./src/orders.txt");
        Map<String, Integer> order = new HashMap<>();


        if (Sklad.isFileEmpty(file) == false) {
            order = Sklad.readOrderFile(file);
        }

        Map<String, Integer> finalOrder1 = order;
        Sklad.addListeners(()-> {
            Map<String, Integer> orders = finalOrder1;
            int max = 0;
            int count = 0;
            for (Map.Entry<String, Integer> map: orders.entrySet()){
                System.out.println(map.getKey() + " " + map.getValue());
                if(map.getValue() > max){
                    max = map.getValue();
                }
                count += map.getValue();
            }
            System.out.println("max: " + max + "\n" + "sum: " + count);
        });

        boolean exit = true;

        System.out.println("[1] вывод всех товаров\t [2] добавление\t " +
                "[3] удаление со склада\t [4] изменение количества товаров\t [5] выход");
        while (exit) {
            char key = sc.next().charAt(0);
            switch (key) {
                case '1':
                    System.out.println(order);
                    break;
                case '2':
                    Map<String, Integer> finalOrder = order;
                    order = Sklad.addMap(order);
                    break;
                case '3':
                    System.out.println("который хотите удалить");
                    String nameProductDelete = sc.next();
                    Sklad.orderDelete(order, nameProductDelete);
                    break;
                case '4':
                    System.out.println("товар которой хотите изменить");
                    String name = sc.next();
                    int quantity = sc.nextInt();
                    Sklad.changeQuantity(order, name, quantity);
                    break;
                case '5':
                    Sklad.writeOrderToFile(order, file);
                    exit = false;
            }

        }
    }
}
