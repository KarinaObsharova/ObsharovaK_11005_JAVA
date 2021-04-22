public class Circle extends Shape {

    public Circle(double radius, double pi){
        super(radius, pi);
    }

    @Override
    public double getArea() {
        System.out.print("Площадь круга: ");
        final double b = 3.14;
        return a * a * b;
    }
}
