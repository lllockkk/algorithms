package sorting;

import java.util.Arrays;
import java.util.concurrent.Exchanger;

/**
 * Created by L on 2017/9/21.
 */
public class _06Quick {
    private static int M = 10;
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    
    public static void sort(Comparable[] a) {
        // TODO: 2017/9/21 打乱a数组，消除对输入的依赖

        sort3way(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
//        优化1：当数组小时，使用插入排序
//        if (hi <= lo + M) { _02Insertion.sort(a, lo, hi);}
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
//            while (a[++i].compareTo(v) < 0) {
//                if (i == hi)
//                    break;
//            }
//
//            while (a[--j].compareTo(v) >= 0) {
//                if (j == lo)
//                    break;
//            }

            while (a[++i].compareTo(v) == -1 && i < j && i < hi);
            while (a[--j].compareTo(v) >= 0 && j > lo);

            if (i >= j)
                break;

            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    //
    private static void sort3way(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        Comparable v = a[lo];

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, i++, lt++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
