public class Rectengal extends Shape{
    public Rectengal(double lenght, double width){
        super(lenght, width);
    }

    @Override
    public double getArea() {
        System.out.print("Площадь прямоугольника: ");
        return a * b;
    }
}
