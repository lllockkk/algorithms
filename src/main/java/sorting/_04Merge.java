package sorting;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Arrays;

/**
 * 自顶向下归并排序
 *
 * 优化：
 * 1、对小规模子数组使用插入排序
 * 2、如果a[mid]是否小与等于a[mid+1]，数组就已经有序，可以跳过merge()方法
 * 3、节省复制到辅助数组所用的时间：交换输入数组和辅助数组的角色
 * Created by L on 2017/9/3.
 */
public class _04Merge {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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
