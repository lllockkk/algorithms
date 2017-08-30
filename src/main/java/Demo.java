import fundamentals._03Queue;

import java.util.Arrays;

/**
 * Created by L on 2017/8/26.
 */

// 双栈 实现基本算术
public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 2,4,5,6,7,-2,-6, 0};
        System.out.println(count(array));
    }

    public static int count(int[] a) {
        Arrays.sort(a);
        int len = a.length;
        int counter = 0;

        for (int i=0; i<len - 1; i++) {
            for (int j=i+1; j<len; j++) {
                int k = Arrays.binarySearch(a, -(a[i]+a[j]));
                if (k > j) {
                    counter++;
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
        return counter;
    }
}














