import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = new int[5];
        System.out.println("Введите массив:");
        for (int i : new Range(a.length, 0)) {
            a[i] = s.nextInt();
        }
        System.out.println("Введите с какого элемента вывести массив:");
        int start = s.nextInt();
        if (start < a.length) {

            System.out.println("Исходный массив: ");
            for (int i : new RangeInterval(a.length, start)) {
                System.out.print(a[i] + " ");
            }
        }else{
            System.out.println("False");
            }
        }

    }

