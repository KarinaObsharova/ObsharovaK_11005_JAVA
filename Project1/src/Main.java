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



        ArrayList<Order> orders1 = new ArrayList<>();
        for (int i = 0; i < orders.toArray().length; i++) {
            int discount = (orders.get(i).discount * orders.get(i).price) / 100;
            orders1.add(new Order(orders.get(i).nameBuyer, orders.get(i).shopName, orders.get(i).productName, discount));
        }

        ArrayList<Order> result = new ArrayList<>();
        int count =0;
        for (int i = 0; i < orders1.size(); i++) {
            for (int j = 0; j < orders1.size(); j++) {
                if( orders1.get(i).nameBuyer.equals(orders1.get(j).nameBuyer)
                        && orders1.get(i).shopName.equals(orders1.get(j).shopName)){
                    count = count + orders1.get(i).price;
                    orders1.remove(j);

                }
            }
            result.add(new Order(orders1.get(i).nameBuyer, orders1.get(i).shopName, count));
            count = 0;
        }
        System.out.println(result);


        }

    }


