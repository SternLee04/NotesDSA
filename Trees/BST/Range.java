import java.util.*;

/**
 * Range
 */
public class Range {
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

        void printRange(Node root, int start, int end) {
            if (root == null) {
                return;
            }
            
            if (root.data >= start && root.data <= end) {
                printRange(root.left, start, end);
                System.out.print(root.data + " ");
                printRange(root.right, start, end);
            } else if (root.data < start) {
                printRange(root.left, start, end);
            } else if (root.data > end) {
                printRange(root.right, start, end);
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        tree.printRange(root, 0, 10);
    }
}