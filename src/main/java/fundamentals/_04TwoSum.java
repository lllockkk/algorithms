package fundamentals;

import java.util.Arrays;

/**
 * Created by L on 2017/8/27.
 * 从一个数组中找出所有 两个和为0 数对
 */
public class _04TwoSum {
    // 假设所有数字不相同，因为二分查找只能找一个
    public static int count(int[] a) {
        Arrays.sort(a);
        int len = a.length;
        int counter = 0;
        for (int i=0; i<len; i++) {
            if (Arrays.binarySearch(a, -a[i]) > i)
                counter++;
        }
        return counter;
    }
}
