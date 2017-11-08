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
        put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = put(node, key, value);
        } else if (cmp > 0) {
            node.right = put(node, key, value);
        } else {
            node.val = value;
        }
        node.N = size(node.left) + size(node.right);
        return node;
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
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
        if (t != null) return t;
        else return node;
    }
}
