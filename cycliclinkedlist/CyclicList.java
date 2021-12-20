package interview.сollection.cycliclinkedlist;

import java.util.Iterator;

public class CyclicList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;
    private static int size;

    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
            head.prev = null;
            last = head;
            head.next = last;
        } else {
            Node<T> temp = new Node<>(element);
            last.next = temp;
            temp.prev = last;
            temp.next = head;
            last = temp;
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new CycleIterator();
    }


    private static class Node<T> {
        private final T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private class CycleIterator implements Iterator<T> {
        Node<T> current = head;
        Node<T> next = current.next;


        @Override
        public boolean hasNext() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        public T next() {
            current = next;
            next = next.next;
            return current.value;
        }
    }

    public static void main(String[] args) {
        CyclicList<Integer> list = new CyclicList<>();
        list.add(12);
        list.add(15);
        list.add(18);
        list.add(19);
        list.add(20);
        for (Integer integer : list) System.out.println(integer);
    }

}
