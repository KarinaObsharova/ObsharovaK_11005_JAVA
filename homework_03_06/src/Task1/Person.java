package Task1;

import Task1.Countries;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;
    Countries country;
    Person(String name, int age, Countries countries) {
        this.name = name;
        this.age = age;
        this.country = countries;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + country;

    }
}
