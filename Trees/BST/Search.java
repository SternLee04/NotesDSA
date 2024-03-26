import java.util.*;

/**
 * 
 */
public class Search {
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

        boolean search(Node root, int val) {
            if (root == null)
                return false;

            if (root.data > val) {
                return search(root.left, val);// left subtree will find and return answer.
            } else if (root.data < val) {
                return search(root.right, val);// right subtree will find and return answer.
            } else
                return true; // where root == val.
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        if (tree.search(root, 3)) {
            System.out.println("Yes");
        }else {
            System.out.println("no");
        }
    }
}