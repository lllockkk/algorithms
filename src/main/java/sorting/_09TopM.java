package sorting;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 查找第M大(小)的数
 * Created by L on 2017/10/25.
 */
public class _09TopM {
    public static void main(String[] args) {
        /*Integer[] a = {5, 4, 23, 12, 6, 5, 7, 52, 3};
        for (int i=1; i<=a.length; i++) {
            System.out.println(heapSelect(a, i));
        }*/



        BigDecimal d = new BigDecimal(1.55505 + "");
        /*DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(d));*/
        d = d.setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println(d);
    }


    public static Comparable partSelect(Comparable[] a, int k) {
        if (k > a.length)
            throw new RuntimeException("k大于数组长度");

        // 第k小
        k = a.length - k + 1;
        // 索引应该减1
        k--;
        int lo = 0;
        int hi = a.length - 1;
        while (true) {
            int j = partition(a, lo, hi);
            if (j == k)
                return a[j];
            if (j < k)
                lo = j + 1;
            else
                hi = j - 1;
        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i].compareTo(v) == -1 && i < j && i < hi);
            while (a[--j].compareTo(v) >= 0 && j > lo);
            if (i >= j)
                break;

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }


    public static Comparable heapSelect(Comparable[] a, int k) {
        if (k > a.length)
            throw new RuntimeException("k大于数组长度");

        // 第k小
        k = a.length - k + 1;

        _07MaxPQ pq = new _07MaxPQ(10);
        for (int i=0; i<k; i++) {
            pq.insert(a[i]);
        }

        for (int i=k; i<a.length; i++) {
            Comparable max = pq.getMax();
            if (max.compareTo(a[i]) == 1) {
                pq.delMax();
                pq.insert(a[i]);
            }
        }

        return pq.getMax();
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
