import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("До какого числа ввывести числа Фибаначчи: ");
        int fibNumber = sc.nextInt();
        int[] arrayfib = new int[fibNumber];
        for (int i = 0; i < arrayfib.length; i++) {
            arrayfib[i] = fib(i);
            System.out.print(arrayfib[i]+ " " );
        }
        System.out.println();
        System.out.println( "До какого числа вывести массив: ");
        int n = sc.nextInt();
        System.out.println("Исходный массив: ");
        for(int i: new FibonacciRange(n)){
            System.out.print(arrayfib[i] + " ");
        }

    }

        public static int fib(int n) {
                if (n < 2)
                    return n;
                return fib(n - 1) + fib(n - 2);
            }

    }


