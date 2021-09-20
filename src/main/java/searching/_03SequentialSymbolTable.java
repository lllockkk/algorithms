package searching;

import java.nio.file.FileStore;
import java.util.*;

public class _03SequentialSymbolTable<Key, Value> implements _01SymbolTable<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    @Override
    public void put(Key key, Value value) {
        for (Node p = first; p != null; p = p.next) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public Value get(Key key) {
        for (Node p = first; p != null; p = p.next) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        Node p = first;
        if (p == null) {
            return;
        }
        if (p.key.equals(key)) {
            first = p.next;
        }
        for (Node q = p.next; q != null; p = q, q = q.next) {
            if (q.key.equals(key)) {
                p.next = q.next;
                return;
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        for (Node p = first; p != null; p = p.next) {
            if (p.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Node p = first; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        Set<Key> set = new HashSet<>();
        for (Node p = first; p != null; p = p.next) {
            set.add(p.key);
        }
        return set;
    }
}
