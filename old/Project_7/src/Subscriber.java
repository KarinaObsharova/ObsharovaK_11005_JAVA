import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subscriber {
    private int account;
    private Tariff services;
    private String number;

    public Subscriber(String number, Tariff services, int account){
        this.number = number;
        this.services = services;
        this.account = account;
    }

    String changeNumber(){
        StringBuilder number = new StringBuilder("8917");
         for (int i = 0; i < 7; i++) {
             number.append((int) (Math.random() * 10));
         }
         return number.toString();
    }

    static String check() {
        Scanner s = new Scanner(System.in);
        String number = s.next();
        Pattern pattern = Pattern.compile("[8][1-9]{10}");
        Matcher matcher = pattern.matcher(number);
        boolean matches = matcher.matches();
        if (!matches) {
            System.out.println(PhoneStation.ANSI_RED + "Неверно набран номер.\n" + PhoneStation.ANSI_RESET + "--------------");
            System.out.println("Введите повторно номер телефона: ");
            check();
        }
        return number;
    }

    static boolean checkSubscriber(String number) {
        boolean check = true;
        for (int i = 0; i < PhoneStation.subscribers.size(); i++) {
            if (PhoneStation.subscribers.get(i).getNumber().equals(number)) {
                check = false;
            }
        }
        return check;
    }

    void addSum(int addSum) {
        account += addSum;
        System.out.println("Ваш баланс:" + account + "\n");
    }

    void reduceSum(int cost){
        account -= cost;
    }

    @Override
    public String toString() {
        return "Пользователь: " + number + "\n" + "Баланс: " + account + "\n" + "Услуга: " + services;
    }

    public int getAccount(){
         return account;
    }
    public void setServices(Tariff services){
        this.services = services;
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
}
