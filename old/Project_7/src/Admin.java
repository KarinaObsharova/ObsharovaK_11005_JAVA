import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static ArrayList<Applications> onTariff = new ArrayList<>();
    static Scanner s = new Scanner(System.in);
    static ArrayList<ApplicationsNumber> onNumber = new ArrayList<>();
    static ArrayList<Applications> offTariff = new ArrayList<>();

    public void checkAdmin() {
        System.out.println("Введите пароль: ");
        int password = s.nextInt();
        if (password == 123) menu();
        else {
            System.out.println("Неверный пароль");
            checkAdmin();
        }
    }

    static void menu() {

        while (true) {
            System.out.println("[1] Заявки на подключение тарифа\t" + "[2] Заявки на смену номера\n"
                    + "[3] Список пользователей\t        " + "[4] Заявки на отказ от услуги\n"
                    + "[5] Назад");
            char key = s.next().charAt(0);
            switch (key) {
                case '1':
                    for (int i = 0; i < onTariff.size(); i++) {
                        System.out.println(onTariff.get(i));
                    }
                    boolean help = true;
                    while (help) {
                        System.out.println("[1] Подключить все услуги\t");
                        char key1 = s.next().charAt(0);
                        switch (key1) {
                            case '1':
                                for (int i = 0; i < PhoneStation.subscribers.size(); i++) {
                                    for (int j = 0; j < onTariff.size(); j++) {
                                        if (PhoneStation.subscribers.get(i).getNumber().equals(onTariff.get(j).getSubscriber().getNumber())) {
                                            PhoneStation.subscribers.get(i).setServices(onTariff.get(j).getTariff());
                                        }
                                    }
                                }
                                System.out.println(PhoneStation.ANSI_GREEN + "Услуги подключины." + PhoneStation.ANSI_RESET);
                                for (int i = 0; i < PhoneStation.subscribers.size(); i++) {
                                    for (int j = 0; j < onTariff.size(); j++) {
                                        if (PhoneStation.subscribers.get(i).getNumber().equals(onTariff.get(j).getSubscriber().getNumber())) {
                                            PhoneStation.subscribers.get(i).reduceSum(onTariff.get(j).getTariff().getCost());
                                        }
                                    }
                                }
                                onTariff.clear();
                                help = false;
                                break;

                        }
                    }
                    break;
                case '2':
                    boolean exit = true;
                    while (exit) {
                        if (onNumber.size() != 0) {
                            System.out.println(onNumber.get(0));
                            System.out.println("[1] Сменить номер\t" + "[2] Отклонить\t" + "[3] Назад");
                            char key2 = s.next().charAt(0);
                            switch (key2) {
                                case '1':
                                    for (int i = 0; i < PhoneStation.subscribers.size(); i++) {
                                        if (PhoneStation.subscribers.get(i).getNumber().equals(onNumber.get(0).subscriber().getNumber())) {
                                            PhoneStation.subscribers.get(i).setNumber(onNumber.get(0).getNumber());
                                            onNumber.remove(0);
                                            System.out.println(PhoneStation.ANSI_GREEN + "Заявка одобрена." + PhoneStation.ANSI_RESET);
                                            break;
                                        }
                                    }
                                    break;
                                case '2':
                                    onNumber.remove(0);
                                    PhoneStation.subscriber.addSum(500);
                                    System.out.println(PhoneStation.ANSI_RED + "Заявка отклонена." + PhoneStation.ANSI_RESET);
                                    break;
                                case '3':
                                    exit = false;
                            }
                        } else {
                            System.out.println("Заявок нет.");
                            exit = false;
                        }
                    }
                    break;
                case '3':
                    for (int i = 0; i < PhoneStation.subscribers.size(); i++) {
                        System.out.println(PhoneStation.subscribers.get(i));
                    }
                    break;
                case '4':
                    boolean exit1 = true;
                    while (exit1) {
                        if (offTariff.size() != 0) {
                            System.out.println(offTariff.get(0) + "\n" + "[1] Отключить услугу\t" + "[2] Отмена");
                            char key2 = s.next().charAt(0);
                            switch (key2) {
                                case '1':
                                    for (int i = 0; i < PhoneStation.subscribers.size(); i++) {
                                        if (PhoneStation.subscribers.get(i).getNumber().equals(offTariff.get(0).getSubscriber().getNumber())) {
                                            PhoneStation.subscribers.get(i).setServices(null);
                                            offTariff.remove(0);
                                            System.out.println(PhoneStation.ANSI_GREEN + "Услуга отключена." + PhoneStation.ANSI_RESET);
                                            break;
                                        }
                                    }
                                    break;
                                case '2':
                                    exit1 = false;
                                    break;
                            }
                        } else {
                            System.out.println("Заявок нет.");
                            exit1 = false;
                        }
                    }
                    break;
                case '5':
                    PhoneStation.login();
            }
        }
    }
}



