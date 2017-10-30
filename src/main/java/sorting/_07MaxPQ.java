package sorting;

/**
 * 基于堆的优先队列
 * 新增、查询时间复杂度都为lgN
 * Created by L on 2017/10/24.
 */
public class _07MaxPQ<T extends Comparable<T>> {
    public static void main(String[] args) {
        _07MaxPQ<Integer> pq = new _07MaxPQ<>(10);
        pq.insert(10);
        pq.insert(7);
        pq.insert(8);
        pq.insert(8);
        pq.insert(2);
        pq.insert(6);
        pq.insert(6);
        pq.insert(6);
        pq.insert(6);
        pq.insert(6);
        while (pq.size() > 0)
            System.out.println(pq.delMax());
    }

    private T[] pq;
    private int N = 0;

    public _07MaxPQ(int maxN) {
        pq = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(T t) {
        pq[++N] = t;
        swim(N);
    }

    public T delMax() {
        T max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public T getMax() {
        return pq[1];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) == -1;
    }

    private void exch(int i, int j) {
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int n) {
        while (n > 1 && less(n/2, n)) {
            exch(n/2, n);
            n = n / 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j ,j+1)) j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

}
