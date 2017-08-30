package fundamentals;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * Created by L on 2017/8/25.
 */
public class _01BinarySearch {
    public static void main(String[] args) {
        System.out.println((1 + 2.236) / 2);
    }
    public static int rank(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (value < array[mid]) high = mid - 1;
            else if (value > array[mid]) low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

}
