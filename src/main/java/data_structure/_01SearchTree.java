package data_structure;

/**
 * Created by L on 2017/10/23.
 * 二叉查找树
 */
public class _01SearchTree<T extends Comparable> {
    private TreeNode<T> root;

    public void clear() {
        root = null;
    }

    public TreeNode<T> find(T ele) {
        return find(root, ele);
    }

    private TreeNode<T> find(TreeNode<T> node, T ele) {
        if (node == null)
            return null;
        if (node.ele.compareTo(ele) == 0)
            return node;
        return node.ele.compareTo(ele) < 0 ? find(node.left, ele) : find(node.right, ele);
    }

    public TreeNode<T> findMin() {
        return findMin(root);
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode<T> findMax() {
        return findMax(root);
    }

    private TreeNode<T> findMax(TreeNode<T> node) {
        if (node == null)
            return null;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void insert(T ele) {
        if (root == null) {
            root = new TreeNode<>();
            root.ele = ele;
        }
        insert(root, ele);
    }

    private void insert(TreeNode<T> node, T ele) {
        if (node.ele.compareTo(ele) < 0) {
            if (node.left == null) {
                node.left = new TreeNode<>();
                node.left.ele = ele;
            }
            else {
                insert(node.left, ele);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode<>();
                node.right.ele = ele;
            }
            else {
                insert(node.right, ele);
            }
        }
    }

    public void delete(T t) {

    }
}

class TreeNode<T> {
    T ele;
    TreeNode<T> left;
    TreeNode<T> right;
}
