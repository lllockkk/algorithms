package sorting;

import java.util.Arrays;

/**
 * 自底向上归并排序
 * Created by L on 2017/9/3.
 */
public class _05MergeBU {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int len = a.length;
        aux = new Comparable[len];
        for (int sz=1; sz<len; sz=sz+sz) {
            for (int lo=0; lo<len-sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, len-1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        for (int k=lo; k<=hi; k++) {
            if (i > mid)
                a[k] = aux[j++];

            else if (j > hi )
                a[k] = aux[i++];

            else if (aux[j].compareTo(aux[i]) < 0)
                a[k] = aux[j++];

            else
                a[k] = aux[i++];

        }
    }
}











