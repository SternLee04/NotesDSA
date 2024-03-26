import java.util.*;

/**
 * bst == root.left < root < root.right
 * inorder of BST is sorted order.
 * BST timecomplexity : O(H) -> O(log n) < O(H) < O(N)
 * O(log N) == in balance tree.
 * O(N) == in skew tree.
 */
public class Create {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BT {
        Node insert(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }

            if (root.data > val) {
                root.left = insert(root.left, val);
            } else if (root.data < val) {
                root.right = insert(root.right, val);
            }

            return root;
        }

        Node create(int[] nodes, Node root) {
            for (int i = 0; i < nodes.length; i++) {
                root = insert(root, nodes[i]);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);
        }
}