package searching;

/**
 * Created by L on 2017/11/8.
 */
public class _01BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
        }

        public String toString() {
            return key.toString() + val;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        if (cmp > 0)
            return get(node.right, key);

        return node.val;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.val = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        Node node = min(root);
        return node == null ? null : node.key;
    }

    private Node min(Node node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node node) {
        if (node == null)
            return null;
        while (node.right != null)
            node = node.right;
        return node.key;
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        return node == null ? null : node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;

        if (cmp < 0)
            return floor(node.left, key);

        Node t = floor(node.right, key);
        return t == null ? node : t;
    }

    public Key ceil(Key key) {
        Node node = ceil(root, key);
        return node == null ? null : node.key;
    }

    private Node ceil(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;

        if (cmp > 0)
            return ceil(node.right, key);

        Node t = ceil(node.left, key);
        return t == null ? node : t;
    }

    /**
     * 选择第N小的键
     * @param k
     * @return
     */
    public Key select(int k) {
        if (k > root.N)
            return null;
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int size = size(node.left);
        if (size > k)
            return select(node.left, k);
        else if (size < k)
            return select(node.right, k-size-1);
        else
            return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null)
            return 0;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node.left, key);
        if (cmp > 0)
            return rank(node.right, key) + 1 + size(node.left);
        else
            return size(node.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    // TODO: 2017/11/9 随机选择前继或后续节点
    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null)
            return;

        print(node.left);
        System.out.println(node);
        print(node.right);
    }


    public static void main(String[] args) {
        _01BST<Integer, String> tree = new _01BST<>();
        tree.put(10, "ten");
        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(7, "seven");
        tree.put(8, "eight");
        tree.print();
        /*System.out.println("size(): " + tree.size());
        System.out.println("min(): " + tree.min());
        System.out.println("max(): " + tree.max());
        System.out.println("get(3): " + tree.get(3));
        System.out.println("get(8): " + tree.get(8));
        System.out.println("floor(4): " + tree.floor(4));
        System.out.println("ceil(4): " + tree.ceil(4));

        int index = tree.select(2);
        System.out.println("select(2): " + index);
        System.out.println("rank(select(2)): " + tree.rank(index));*/
    }
}
