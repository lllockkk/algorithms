package sorting;

import java.util.Arrays;

/**
 * 选择排序
 * 比较次数和交换次数固定，分别为~N²/2和 N
 * Created by L on 2017/9/1.
 */
public class _01Selection {

    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (a[min].compareTo(a[j]) > 0)
                    min = j;
            }

            Comparable temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
