package sorting.impl;

import sorting.AbstractSort;

/**
 *
 * ===== 选择排序 =====
 *
 * 1) 描述
 * 首先将找到数组中最小的，与第一个元素交换
 * 从剩余数组中找到最小的，与第二个元素交换
 * 以此类推
 *
 * 2) 时间复杂度
 * 比较次数：(N-1) + ... + 1 = (N-1)N / 2，交换次数 N
 * 交换次数: N
 *
 * 3) 空间复杂度
 * O(N)
 *
 */
public class Selection extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
