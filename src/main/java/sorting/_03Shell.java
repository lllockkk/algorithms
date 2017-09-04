package sorting;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Arrays;

/**
 * 希尔排序
 * 在最坏的情况下比较次数和N^(1.5)成正比
 * Created by L on 2017/9/2.
 */
public class _03Shell {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int len = a.length;
        int h = 1;
        while (h < len/3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i=h; i<len; i++) {
                for (int j=i; j>=h && a[j].compareTo(a[j-h]) < 0; j -= h) {
                    Comparable temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }
            h = h/3;
        }
    }
}
