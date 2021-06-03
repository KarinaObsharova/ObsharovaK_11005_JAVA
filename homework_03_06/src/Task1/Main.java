package Task1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RandomPerson randomPerson = new RandomPerson();
        Thread writer = new Thread(() -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/file.txt"))) {
                Person p = randomPerson.newPerson();
                oos.writeObject(p);
                System.out.println("Writer successfully wrote");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Thread reader = new Thread(() -> {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/file.txt"))) {
            Person person = (Person) in.readObject();
            System.out.println(person);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        for (int i = 0; i < 10; i++) {
            writer.run();
            writer.join();
            reader.run();
            reader.join();
            Thread.sleep(1000);
        }

    }
}
