import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;



public class CrudTest {
    Crud<Animals> test;
    Animals animal;

    @Before
    public void prepare() {
        test = new Crud<>();
        animal = new Animals("Bob", 25);
    }

    @Test
    public void createTestSuccess() {
        test.create(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTestFailed() {
        test.create(animal);
        test.create(animal);
    }

    @Test
    public void readTestSuccess() {
        test.create(animal);
        test.read(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void readTestFailed() {
        test.read(0);
    }

    @Test
    public void updateTestSuccess() {
        test.create(animal);
        test.update(new Animals("Bob", 27));
    }

    @Test(expected = NoSuchElementException.class)
    public void updateTestFailed() {
        test.update(new Animals("Bob", 27));
    }

    @Test
    public void deleteTestSuccess() {
        test.create(animal);
        test.delete(animal);
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteTestFailed() {
        test.delete(animal);
    }

    @Test
    public void printTestSuccess() {
        test.create(animal);
        for (Animals x : test.items) {
            x.print();
        }
    }
}