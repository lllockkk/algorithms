package sorting;

public abstract class AbstractSort implements Sort {
    protected static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    protected static <T extends Comparable<T>> boolean less(T i, T j) {
        return i.compareTo(j) < 0;
    }
}
