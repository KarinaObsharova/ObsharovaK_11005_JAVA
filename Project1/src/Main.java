import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Buyer> buyers = new ArrayList<>();
        ArrayList<Discount> discounts = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Purchase> purchases = new ArrayList<>();

        File file = new File("./src/Buyers.txt");
        Scanner sc = new Scanner(file);
        String text = "";
        while (sc.hasNext()) {
            text = sc.nextLine() + "|";
            String[] str = text.split("\\|");
            String buyerName = str[0];
            String cityName = str[1];

            Buyer buyer = new Buyer(buyerName, cityName);
            buyers.add(buyer);

        }
        System.out.println(buyers);

        file = new File("./src/discounts.txt");
        sc = new Scanner(file);
        text = "";
        while (sc.hasNext()) {
            text = sc.nextLine() + "|";
            String[] str = text.split("\\|");
            String shopName = str[0];
            String buyerName = str[1];
            int discount = Integer.parseInt(str[2]);

            Discount discount1 = new Discount(shopName, buyerName, discount);
            discounts.add(discount1);

        }
        System.out.println(discounts);

        file = new File("./src/products.txt");
        sc = new Scanner(file);
        text = "";
        while (sc.hasNext()) {
            text = sc.nextLine() + "|";
            String[] str = text.split("\\|");
            String shopName = str[0];
            String productName = str[1];
            int price = Integer.parseInt(str[2]);

            Product product = new Product(shopName, productName, price);
            products.add(product);

        }
        System.out.println(products);

        file = new File("./src/purchases.txt");
        sc = new Scanner(file);
        text = "";
        while (sc.hasNext()) {
            text = sc.nextLine() + "|";
            String[] str = text.split("\\|");
            String buyerName = str[0];
            String shopName = str[1];
            String productName = str[2];

            Purchase purchase = new Purchase(buyerName, shopName, productName);
            purchases.add(purchase);

        }
        System.out.println(purchases);
        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < purchases.toArray().length; i++) {
            for (int j = 0; j < discounts.toArray().length; j++) {
                for (int k = 0; k < products.toArray().length; k++) {
                    if (purchases.get(i).buyerName.equals(discounts.get(j).buyerName)
                            & purchases.get(i).shopName.equals(discounts.get(j).shopName)
                            & purchases.get(i).productName.equals(products.get(k).productName)
                            & purchases.get(i).shopName.equals(products.get(k).shopName)) {

                        Order order = new Order(purchases.get(i).buyerName, purchases.get(i).shopName,
                                purchases.get(i).productName, products.get(k).price, discounts.get(j).discount);
                        orders.add(order);
                    }
                }
            }
        }
        System.out.println(orders);



        ArrayList<Order> orders1 = new ArrayList<>();
        for (int i = 0; i < orders.toArray().length; i++) {
            int discount = orders.get(i).price - ((orders.get(i).discount * orders.get(i).price) / 100);
            orders1.add(new Order(orders.get(i).nameBuyer, orders.get(i).shopName, orders.get(i).productName, discount));
        }
        System.out.println(orders1);

        }

    }


