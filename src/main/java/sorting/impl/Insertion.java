package sorting.impl;

import sorting.AbstractSort;

public class Insertion extends AbstractSort {

    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                }
            }
        }
    }
}
