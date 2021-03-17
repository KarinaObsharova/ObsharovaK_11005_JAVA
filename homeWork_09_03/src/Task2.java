import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        String string = sc.nextLine();

        String[] strings = string.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if (tryParseInt(strings[i])) {
                int x = Integer.parseInt(strings[i]);
                stack.push(x);
                count++;
            } else {
                stack.push(chekOperator(strings[i].charAt(0), stack.pop(), stack.pop()));
                count = 0;
                count++;
            }
        }
        if (count == 0 || count > 1) {
            System.out.println("String is not correct.");
        } else System.out.println(stack.pop());


    }

    public static boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int chekOperator(char sign, int a, int b) {

        int result = 0;
        switch (sign) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = b / a;
                break;
        }
        return result;
    }


}
