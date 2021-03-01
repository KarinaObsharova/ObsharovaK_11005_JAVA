import java.util.ArrayList;
import java.util.Scanner;

public class PhoneStation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static ArrayList<Subscriber> subscribers = new ArrayList<>();
    static Subscriber subscriber;

    public static void main(String[] args) {
        login();
    }

    static void login() {
        Scanner s = new Scanner(System.in);
        Admin admin = new Admin();


        while (true) {
            System.out.println("[1] Войти в личный кабинет\n"
                    + "[2] Админ");
            char key = s.next().charAt(0);
            switch (key) {
                case '1' -> {
                    System.out.println("Введите номер телефона: ");
                    String number = Subscriber.check();
                    if (Subscriber.checkSubscriber(number)) {
                        subscribers.add(subscriber = new Subscriber(number, null, 0));
                    }else{
                        for (int i = 0; i <subscribers.size(); i++) {
                            if(subscribers.get(i).getNumber().equals(number)){
                                subscriber = subscribers.get(i);
                                break;
                            }
                        }
                    }
                    System.out.println("Вы успешно вошли в систему! \n");
                    for (int i = 0; i < subscribers.size(); i++) {
                        System.out.println(subscribers.get(i));
                    }

                }
                case '2' -> admin.checkAdmin();
            }
            boolean help = true;
            while (help) {
                System.out.println("[1] Пополнить баланс\t" + "[2] Подключить тариф\n"
                        + "[3] Сменить номер    \t" + "[4] Отключить услугу\n" + "[5] Назад");
                char key1 = s.next().charAt(0);
                switch (key1) {
                    case '1' -> {
                        System.out.println("Введите сумму пополнения: ");
                        int sum = s.nextInt();
                        subscriber.addSum(sum);
                    }
                    case '2' -> {
                        Tariff[] listTariff = new Tariff[4];
                        listTariff[0] = new Tariff("Online24/7", 300);
                        listTariff[1] = new Tariff("Premium", 500);
                        listTariff[2] = new Tariff("МойSmart", 400);
                        listTariff[3] = new Tariff("PremiumPRO", 600);
                        System.out.println("Список тарифов: ");
                        for (int i = 0; i < listTariff.length; i++) {
                            System.out.println("[" + (i + 1) + "]" + listTariff[i]);
                        }
                        System.out.println("------------------");
                        System.out.println("Введите номер тарифа: ");
                        int number = s.nextInt();
                        int account = subscriber.getAccount();
                        int cost = listTariff[number - 1].getCost();
                        if (account >= cost) {
                            Admin.onTariff.add(new Applications(subscriber, listTariff[number - 1]));
                            System.out.println(ANSI_GREEN + "Ваша заявка отправлена." + ANSI_RESET);
                        } else
                            System.out.println(ANSI_RED + "Ваша заявка не одобрена" + ANSI_RESET);
                    }
                    case '3' -> {
                        System.out.println("Ваш номер телефона: " + subscriber.getNumber());
                        System.out.println("[1] Cменить номер бесплатно\t     " + "[2] Изменить номер на выбор за 500 рублей");
                        char key2 = s.next().charAt(0);
                        switch (key2) {
                            case '1':
                                Admin.onNumber.add(new ApplicationsNumber(subscriber, subscriber.changeNumber()));
                                System.out.println(Admin.onNumber.get(Admin.onNumber.size() - 1));
                            case '2':
                                if (subscriber.getAccount() < 500) {
                                    System.out.println(ANSI_RED + "Недостаточно средств" + ANSI_RESET);
                                } else {
                                    subscriber.reduceSum(500);
                                    System.out.println("Введите новый номер номер: ");
                                    String newNumber = subscriber.check();
                                    Admin.onNumber.add(new ApplicationsNumber(subscriber, newNumber));
                                }
                        }
                        System.out.println("Ваша заявка на смену номера отправлена.");
                    }
                    case '4' -> {
                        System.out.println(subscriber);
                        boolean exit = true;
                        while (exit) {
                            System.out.println("Вы уверены, что хотите отключить услугу?\n"
                                    + "[1] Да\t  " + "[2] Нет");
                            char key2 = s.next().charAt(0);
                            switch (key2) {
                                case '1':
                                    Admin.offTariff.add(new Applications(subscriber));
                                    System.out.println("Заявка отправлена.");
                                case '2':
                                    exit = false;
                            }
                        }
                    }

                    case '5' -> help = false;
                    case '6' ->{
                    for (int i = 0; i < subscribers.size(); i++) {
                        System.out.println(subscribers.get(i));
                    }
                    }
                }
            }
        }
    }
}


