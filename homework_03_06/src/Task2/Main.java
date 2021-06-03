package Task2;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(4);
    StringBuilder stringBuilder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();


            Callable<String> callable = new Callable() {
                @Override
                public String call() throws Exception {
                    StringBuilder str = new StringBuilder();
                    int random = new  Random().nextInt(6);
                    for (int j = 0; j < random; j++) {
                        int index = new Random().nextInt(chars.length);
                        str.append(chars[index]);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + "добавил новый символ в строку");
                    return str.toString();
                }
            };
        int number = sc.nextInt();
        if(number < 0){
            throw new InvalidParameterException("Введите число больше 0");
        }
        for (int i = 0; i < number; i++) {
            stringBuilder.append(executorService.schedule(callable, 2, TimeUnit.SECONDS).get());
            System.out.println(stringBuilder);
        }
        executorService.shutdown();

    }
}
