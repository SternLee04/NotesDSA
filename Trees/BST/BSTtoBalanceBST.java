import java.util.*;
/**
 * Note that Balance BST is shortest height in BST.
 * 2 Steps : get sorted array.
 *         : make Balance BST
 */
public class BSTtoBalanceBST {
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

        void inorder(Node root, ArrayList<Node> list) {// bst inorder is sorted.
            if(root == null) return;

            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }
        Node ArraytoBalancedBST(ArrayList<Node> list, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;

            Node root = new Node(list.get(mid).data);
            root.left = ArraytoBalancedBST(list, left, mid-1);
            root.right = ArraytoBalancedBST(list, mid+1, right);

            return root;
        }
        Node convertBSTtoBalanceBst(Node root) {
            ArrayList<Node> list = new ArrayList<>();
            inorder(root, list);

            return ArraytoBalancedBST(list, 0, list.size() -1);
        }

    }
    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        Node balancedBst = tree.convertBSTtoBalanceBst(root);
    }
}