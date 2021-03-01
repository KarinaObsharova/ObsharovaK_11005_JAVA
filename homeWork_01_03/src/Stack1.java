import java.util.Iterator;

public class Stack1<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<T> {
        Node temp = head;

        @Override
        public boolean hasNext() {
            if (head == null) {
                head = temp;
                return false;
            } else
                return true;

        }


        @Override
        public T next() {
            T temp = head.value;
            head = head.next;

            return temp;
        }
    }

    static class Node<T> {
        private T value;
        private Node next;

    }

    private Node<T> head;

    public void push(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        node.next = head;
        head = node;
    }

    public T pop() {
        T temp = head.value;
        head = head.next;

        return temp;

    }

    public T peek() {
        return head.value;
    }


    static class Main {
        public static void main(String[] args) {
            Stack1<Integer> stack = new Stack1<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            for (Integer item : stack) {
                System.out.print(item + " ");
            }
            System.out.println();
            System.out.println("Проверка метода pop: " + stack.pop());
            System.out.println("Проверка метода peek: " + stack.peek());
            System.out.println("Ввывод элементов через foreach: ");
            for (Integer item : stack) {
                System.out.print(item + " " );
            }
            System.out.println();
            System.out.println("Многоразовость: ");
            for (Integer item : stack) {
                System.out.print(item + " ");
            }
        }
    }
}
