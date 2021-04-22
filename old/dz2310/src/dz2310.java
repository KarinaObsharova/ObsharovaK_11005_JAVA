
import java.util.Scanner;

public class dz2310 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        // Задание 1
        System.out.println("Введите число n:");
        int n = s.nextInt();
        System.out.println(factorial(n));

        // Задание 2
        System.out.println("Введите число а:");
        int a = s.nextInt();
        System.out.println("Введите число b:");
        int b = s.nextInt();
        System.out.println(score(a, b));


        // Задание 3
        System.out.println("Введите число n:");
        int p = s.nextInt();
        System.out.println(fib(p));

        // Задание 4
        System.out.println("Введите число n:");
        int m = s.nextInt();
        System.out.println("Введите число m:");
        int k = s.nextInt();
        System.out.println(akkerman(m, k));
    }


    public static int factorial(int n){
        if (n <= 1)
            return 1;
        return n * factorial(n-1);
    }
    public static String score(int a, int b) {
        String str = Integer.toString(b);
         if (a == b)
             return str;
        System.out.print(a);
        return score(a+1, b);

    }
    public static int fib(int n) {
        if( n < 2)
            return n;
        return fib(n-1) + fib(n-2);
    }
    public static int akkerman(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (n == 0) {
            return akkerman(m - 1, 1);
        }
        return akkerman(m - 1, akkerman(m, n - 1));
    }
}
