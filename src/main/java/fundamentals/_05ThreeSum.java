package fundamentals;

import java.util.Arrays;

/**
 * Created by L on 2017/8/27.
 */
public class _05ThreeSum {

    public static int count(int[] a) {
        Arrays.sort(a);
        int len = a.length;
        int counter = 0;

        for (int i=0; i<len - 1; i++) {
            for (int j=i+1; j<len; j++) {
                if (Arrays.binarySearch(a, -(a[i]+a[j])) > j) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
