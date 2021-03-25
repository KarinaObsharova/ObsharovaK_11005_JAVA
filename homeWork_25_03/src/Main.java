import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("./src/orders.txt");
        Map<String, Integer> order = new HashMap<>();

        if (isFileEmpty(file) == false) {
            order = readOrderFile(file);
        }
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
                    order = addMap(order);
                    break;
                case '3':
                    System.out.println("который хотите удалить");
                    String nameProductDelete = sc.next();
                    orderDelete(order, nameProductDelete);
                    break;
                case '4':
                    System.out.println("товар которой хотите изменить");
                    String name = sc.next();
                    int quantity = sc.nextInt();
                    changeQuantity(order, name, quantity);
                    break;
                case '5':
                    writeOrderToFile(order, file);
                    exit = false;
            }
        }
    }


    public static void changeQuantity(Map<String, Integer> order, String name, int quantity) {
        if (order.containsKey(name)) {
            order.put(name, order.get(name) + quantity);
        }
    }

    public static void orderDelete(Map<String, Integer> order, String nameProductDelete) {
        if (order.containsKey(nameProductDelete)) {
            order.remove(nameProductDelete, order.get(nameProductDelete));
        }
    }

    public static Map<String, Integer> addMap(Map<String, Integer> order) {
        Scanner sc = new Scanner(System.in);
        order.put(sc.next(), sc.nextInt());
        return order;
    }

    public static void writeOrderToFile(Map<String, Integer> orders, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> readOrderFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            Map<String, Integer> order = (Map<String, Integer>) in.readObject();
            return order;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File is not found");
        }
        return null;
    }

    public static boolean isFileEmpty(File file) {
        return file.length() == 0;

    }

}


