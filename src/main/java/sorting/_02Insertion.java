package sorting;

import java.util.Arrays;

/**
 * 插入排序
 * 比较次数和交换次数与数组顺序有关。
 * 最坏~N²/2 和 ~N²/2；最好N-1 和 0
 * Created by L on 2017/9/2.
 */
public class _02Insertion {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int len = a.length;
        sort(a, 0, len - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i=lo+1; i<hi+1; i++) {
            for (int j=i; j>lo && a[j].compareTo(a[j-1]) < 0; j--) {
                Comparable temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
}
