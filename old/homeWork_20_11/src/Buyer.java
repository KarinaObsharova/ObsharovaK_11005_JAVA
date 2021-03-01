import java.util.ArrayList;
import java.util.Scanner;

public class Buyer {
    private String name;
    private int age;
    private char gender;
    Scanner s = new Scanner(System.in);


    public Buyer(String name, int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static Buyer newBuyer(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name, please: ");
        String name = s.nextLine();
        System.out.println("Enter your age, please:");
        int age = s.nextInt();
        System.out.println("Enter your gender, please:");
        char gender = s.next().charAt(0); s.nextLine();

        Buyer result = new Buyer( name, age, gender);
        System.out.println(result.toString() + "\n" + "You have successfully saved your profile!\n");
        return result;

    }

    public void buy(Product product, ArrayList<Request> request ){
        Request request1 = new Request(this, product);
        request.add(request1);
    }

    @Override
    public String toString() {
        return "Buyer \n"
                + "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Gender: " + gender;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public char getGender() {
        return gender;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
}
