package sorting;

import java.util.Arrays;

/**
 * Created by L on 2017/9/21.
 */
public class _06Quick {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    
    public static void sort(Comparable[] a) {
        // TODO: 2017/9/21 打乱a数组，消除对输入的依赖
        
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        System.out.println(a[5].compareTo(v) >= 0);
        while (true) {
            while (a[++i].compareTo(v) < 0) {
                if (i == hi)
                    break;
            }

            while (a[--j].compareTo(v) >= 0) {
                if (j == lo)
                    break;
            }

            if (i >= j)
                break;

            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        Comparable temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }
}
