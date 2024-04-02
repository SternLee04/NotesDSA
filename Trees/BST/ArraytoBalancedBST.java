import java.util.*;
/**
 * Approch : 
 * binary search on array mid == root.
 * left part of array is left subtree
 * right part of array is right subtree
 */
public class ArraytoBalancedBST {
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

        Node sortedArrayToBalancedBst(int[] nodes, int left, int right) {// O(n)
            if (left > right) return null;

            int mid = left + (right - left) / 2;

            Node root = new Node(nodes[mid]);
            root.left = sortedArrayToBalancedBst(nodes, left, mid-1);
            root.right = sortedArrayToBalancedBst(nodes, mid+1, right);

            return root;
        }
    }
    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        Arrays.sort(nodes);
        Node balancedBst = tree.sortedArrayToBalancedBst(nodes, 0, nodes.length-1);
    }
}