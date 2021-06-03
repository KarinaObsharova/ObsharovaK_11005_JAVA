package Task1;

import Task1.Countries;
import Task1.Person;

public class RandomPerson {
    Person newPerson() {
        String[] arrayName = {"Dima", "Karina", "Masha"};
        String name = arrayName[(int) (Math.random() * arrayName.length)];
        int age = (int) (Math.random() * 100);
        Countries countries = Countries.values()[(int) (Math.random() * Countries.values().length)];
        return new Person(name, age, countries);
    }
}
