import java.util.*;

/**
 * 2 steps : 1 find that node.
 *          2 delete the node.
 * 
 * 3 cases for delete : leaf , one child, two children.
 * 
 */
public class Delete {
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

        Node delete(Node root, int val) {
            // search for that node.
            if (root.data < val) {
                root.right = delete(root.right, val);
            } else if (root.data > val) {
                root.left = delete(root.left, val);
            } else {// found condition.

                // case 1 : leaf Node.
                if (root.left == null && root.right == null) {
                    return null;
                }

                // case 2 : one child.
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // case 3 : leaf node with two children.
                Node insestor = leftMostNode(root.right);
                root.data = insestor.data;
                root.right = delete(root.right, insestor.data);

            }
            return root;
        }

        Node leftMostNode(Node node) {
            Node current = node;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);
    }
}