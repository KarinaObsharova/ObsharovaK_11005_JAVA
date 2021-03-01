public abstract class Shape {
    double a;
    double b;

    public Shape(double a, double b){
        this.a = a;
        this.b = b;
    }

    public abstract double getArea();
}
