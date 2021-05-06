package Task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Sklad {
     static ArrayList<ProductsListener> listeners = new ArrayList<>();

    public static void addListeners(ProductsListener listener){
        listeners.add(listener);
    }

    public static void changeQuantity(Map<String, Integer> order, String name, int quantity) {
    if (order.containsKey(name)) {
        order.put(name, order.get(name) + quantity);
    }
    for (ProductsListener x: listeners){
        x.productsUpdated();
    }
}

    public static void orderDelete(Map<String, Integer> order, String nameProductDelete) {
        if (order.containsKey(nameProductDelete)) {
            order.remove(nameProductDelete, order.get(nameProductDelete));
        }
        for (ProductsListener x: listeners){
            x.productsUpdated();
        }
    }

    public static Map<String, Integer> addMap(Map<String, Integer> order) {
        Scanner sc = new Scanner(System.in);
        order.put(sc.next(), sc.nextInt());
        for (ProductsListener x: listeners){
            x.productsUpdated();
        }
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
