import java.util.*;
/**
 * left subtree in right subtree and vice versa.
 */
public class Mirror
{
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
        void inorder(Node root) {// for mirror inoder is reverse.(desending)
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        Node mirror(Node root) {
            if (root == null) return null;

            Node mirror = new Node(root.data);
            mirror.left = mirror(root.right);
            mirror.right = mirror(root.left);

            return mirror;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        Node mirror = null;
        mirror = tree.mirror(root);

        tree.inorder(root);
        System.out.println();
        tree.inorder(mirror);
    }
}