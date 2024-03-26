import java.util.*;

/**
 * Simple Approch : if inorder is sorted then valid otherwise not;
 * Better Approch : each value in left subtree < Parent < each value in right subtree.
 */
public class Valid {
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

        boolean isValidBST(Node root, Node min, Node max) {
            if (root == null) {
                return true;
            }
            
            // check that node is in range.
            if (min != null && root.data <= min.data) return false;
            else if (max != null && max.data >= max.data) return false;

            // for left subtree parentroot node is max
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
            // for right subtree parentroot node is min
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);
    }
}