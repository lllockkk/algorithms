package fundamentals;

/**
 * Created by L on 2017/8/27.
 */
public class _03Queue<T> {
    private class Node {
        T item;
        Node next;
    }
    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void enqueue(T item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        size++;
    }
    public T dequeue() {
        if (isEmpty())
            return null;
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
