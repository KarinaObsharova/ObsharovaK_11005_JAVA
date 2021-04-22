public class Vector2D {
    private double x;
    private double y;

    public Vector2D( double x, double y ){
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
    }

    public void add(Vector2D other){
        Vector2D v3 = new Vector2D();
      v3.setX(this.x + other.getX());
      v3.setY(this.y + other.getY());
      System.out.println("Add: " + (int) v3.getX() + " " + (int) v3.getY());
    }

    public void sub(Vector2D other){
        Vector2D v3 = new Vector2D();
        v3.setX(this.x - other.getX());
        v3.setY(this.y - other.getY());
        System.out.println("Sud: " + (int) v3.getX() + " " + (int) v3.getY());
    }
    public void mult(double t){
        Vector2D v3 = new Vector2D();
        v3.setX(this.x * t);
        v3.setY(this.y * t);
        System.out.println("Mult: " + (int) v3.getX() + " " + (int) v3.getY());
    }


    public void setX(double x){
        this.x = x;
   }
   public double getX(){
        return x;
   }
   public void setY(double y){
        this.y = y;
   }
   public double getY(){
        return y;
   }
}
