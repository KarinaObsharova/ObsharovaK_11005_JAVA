import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Vector2D v1 = new Vector2D(s.nextDouble(),s.nextDouble());
    Vector2D v2 = new Vector2D(s.nextDouble(), s.nextDouble());
    v1.add(v2);
    v1.sub(v2);
    System.out.println("Введите константу, умножаемую на вектор: ");
    final int CONST  = s.nextInt();
    v1.mult(CONST);
    }
}
