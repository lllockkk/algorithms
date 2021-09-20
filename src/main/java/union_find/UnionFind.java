package union_find;

public interface UnionFind {
    int find(int p);
    int count();
    boolean connected(int p, int q);
    void union(int p, int q);
}
