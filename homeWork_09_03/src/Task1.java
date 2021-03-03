import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();
        String string = sc.nextLine();

        char[] charArray = {'(', '{', '['};
        char[] charArray1 = {')', '}', ']'};
        boolean check = true;

        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < charArray.length; j++) {
                if (string.charAt(i) == charArray[j]) {
                    stack.add(charArray[j]);
                    break;
                }
                if (string.charAt(i) == charArray1[j]) {
                    if (charArray[j] != stack.pop()) {
                        check = false;
                        break;
                    }

                }
            }
            if (!check) {
                System.out.println("false, string not correction");
                break;
            }
        }
        if (check) {
            System.out.println("true");
        }
    }
}

