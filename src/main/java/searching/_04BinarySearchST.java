package searching;

public class _04BinarySearchST<Key extends Comparable<Key>, Value> implements _02Sorted01SymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public static void main(String[] args) {
        Integer i = 1;
        Integer[] test = test(i);
    }

    public static <T> T[] test(T t) {
        T[] ts = (T[]) new Comparable[10];
        return ts;
    }

    public _04BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
    }
    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceil(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
