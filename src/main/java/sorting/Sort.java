package sorting;

public interface Sort {
    <T extends Comparable<T>> void sort(T[] a);
}

