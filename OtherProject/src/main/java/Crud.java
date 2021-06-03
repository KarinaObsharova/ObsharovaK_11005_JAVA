import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Crud<T extends Comparable<T> & Printable> {

        ArrayList<T> items = new ArrayList<>();

        public void create(T item) throws IllegalArgumentException {
            for (T x : items) {
                if (x.compareTo(item) == 0) {
                    throw new IllegalArgumentException("ебанутый, такое число уже есть");
                }
            }
            items.add(item);
        }

        public T read(int id) throws NoSuchElementException {
            int i = -1;
            for (T x : items) {
                i++;
                if (i == id)
                    return x;
            }
            throw new NoSuchElementException("сосать+лежать");
        }

        public void update(T item) throws NoSuchElementException {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).compareTo(item) == 0) {
                    items.set(i, item);
                    return;
                }
            }
            throw new NoSuchElementException();
        }

        public void delete(T item) throws NoSuchElementException {
            for(int i=0;i<items.size();i++) {
                if (items.get(i).compareTo(item)==0) {
                    items.remove(i);
                    return;
                }
            }
            throw new NoSuchElementException("сосать+лежать");
        }
    }


