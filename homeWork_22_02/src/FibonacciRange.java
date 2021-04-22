import java.util.Iterator;

public class FibonacciRange implements Iterable<Integer> {
    protected int length;
    protected int counter;
    public FibonacciRange(int length) {
        this.length = length;
        counter = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return counter < length;
            }

            @Override
            public Integer next() {
                return counter++;
            }
        };
    }

}
