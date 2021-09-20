package sorting;

import sorting.impl.Insertion;
import sorting.impl.Selection;

public class SortTest {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        test(new Insertion(), a);
    }

    public static <T extends Comparable<T>> void test(Sort sort, T[] a) {
        sort.sort(a);
        System.out.println(isSort(a));
    }

    public static <T extends Comparable<T>> boolean isSort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
