public class Triangle extends Shape{
    public Triangle(double wight , double base ){
        super(wight, base);
    }
    @Override
    public double getArea() {
        System.out.print("Площадь треугольника: ");
        return 0.5 * a * b;
    }
}
