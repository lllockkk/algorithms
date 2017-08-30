package fundamentals;

/**
 * Created by L on 2017/8/27.
 */
public class _02Stack<T> {
    private class Node {
        T item;
        Node next;
    }

    private int size;
    private Node first;


    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
    public T pop() {
        if (isEmpty())
            return null;

        T item = first.item;
        first = first.next;
        size--;
        return item;
    }
}

