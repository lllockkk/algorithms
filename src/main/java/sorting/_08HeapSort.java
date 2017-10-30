package sorting;

import java.util.Arrays;

/**
 * 对排序
 * Created by L on 2017/10/24.
 */
public class _08HeapSort {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int i=(N-1)/2; i>=0 ;i--) {
            sink(a, i, N);
        }

        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) == -1;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sink(Comparable[] a, int i, int N) {
        // 左子节点
        while (2*i + 1 <= N) {
            int j = 2*i+1;
            // 找出大的子节点
            if (j + 1 <= N && less(a, j, j + 1))
                j++;

            if (!less(a, i, j))
                break;

            exch(a, i, j);
            i = j;
        }
    }
}
