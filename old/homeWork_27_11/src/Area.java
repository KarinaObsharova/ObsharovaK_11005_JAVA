import java.util.Scanner;

public class Area {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Shape[] shapes = new Shape[6];
        System.out.println("Площадь первого прямоугольника. Введите пременную a и b: ");
        shapes[0] = new Rectengal( s.nextDouble(), s.nextDouble());
        System.out.println("Площадь второго прямоугольника. Введите пременную a и b: ");
        shapes[1] = new Rectengal( s.nextDouble(), s.nextDouble());
        System.out.println("Площадь первого круга. Введите радиус круга: ");
        shapes[2] = new Circle(s.nextDouble(),3.14);
        System.out.println("Площадь второго круга. Введите радиус круга: ");
        shapes[3] = new Circle(s.nextDouble(),3.14);
        System.out.println("Площадь первого треугольника. Введите высоту и основание: ");
        shapes[4] = new Triangle(s.nextDouble(), s.nextDouble());
        System.out.println("Площадь второго треугольника. Введите высоту и основание: ");
        shapes[5] = new Triangle(s.nextDouble(), s.nextDouble());

        for (int i = 0; i < shapes.length; i++) {
            double area = shapes[i].getArea();
            System.out.println( (int) area);

        }
    }
}
