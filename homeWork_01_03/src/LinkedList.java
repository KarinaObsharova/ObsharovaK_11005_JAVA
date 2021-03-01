import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    class ListIterator implements Iterator<T>{
        Node temp = head;
        @Override
        public boolean hasNext() {
            if(head == null) {
                head = temp;
                return false;
            } else
            return true;
        }

        @Override
        public T next() {
            T value =head.item;
            head = head.next;


            return value;
        }
    }

    static class Node<T> {
        private T item;
        private Node next;
    }

    private Node<T> head;

    void add(T item) {
        Node<T> node = new Node<>();
        node.item = item;
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    T get(int id) {
        int count = 0;
        Node temp = head;
        while (count != id) {
            count++;
            temp = temp.next;
        }
        return (T) temp.item;
    }

    int size() {
        Node temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Проверка метода get: " + list.get(3));
        System.out.println("Проверка метода size: " + list.size());

        System.out.println("Ввывод элементов через foreach: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Многоразовость: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        }

    }



