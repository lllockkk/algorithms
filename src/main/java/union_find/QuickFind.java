package union_find;

public class QuickFind implements UnionFind {
    private int[] arr;
    private int count;

    public QuickFind(int N) {
        this.count = N;
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = i;
        }
    }

    @Override
    public int find(int i) {
        return arr[i];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(p);
        if (pId != qId) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == pId) {
                    arr[i] = qId;
                }
            }
            count--;
        }
    }

    private void check(int ... arr) {
        if (arr != null) {
            for (int i : arr) {
                if (i >= count) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }
    }
}
