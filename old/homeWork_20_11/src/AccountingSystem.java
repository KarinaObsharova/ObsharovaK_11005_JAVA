import java.util.ArrayList;
import java.util.Scanner;

public class AccountingSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Request> a1 = new ArrayList<>();
        ArrayList<Buyer> buyers = new ArrayList<>();


        Product[] product = new Product[3];
        product[0] = new Product("IPhone", 60000, "Apple");
        product[1] = new Product("VR", 1200, "Samsung");
        product[2] = new Product("Robot Cleaner", 14000, "360 HEPA");


        boolean continueWork = true;
        while (continueWork) {
            System.out.println("To add a new user enter: [u] \n"
                    + "List of orders: [l] \n"
                    + "View the list of products: [p] \n"
                    + "make an order: [o]");
            char key = s.next().charAt(0);
            switch (key) {
                case 'u':
                    buyers.add(Buyer.newBuyer());
                    break;
                case 'l':
                    for (int i = 0; i < a1.size(); i++) {
                        System.out.println(a1.get(i));
                    }
                    break;
                    case 'p':
                        int count = 1;
                        for (int i = 0; i < product.length; i++) {
                            System.out.println(count + ". " + product[i]);
                            count++;
                        }
                        System.out.println();
                        break;
                        case 'o':
                            System.out.println("Enter your order number:");
                            int number = s.nextInt();
                            buyers.get(buyers.size() - 1).buy(product[number - 1], a1);
                            continueWork = true;
                            break;

            }
        }

    }
}
