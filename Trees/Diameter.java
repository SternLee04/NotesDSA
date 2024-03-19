import java.util.*;

public class Diameter {
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        public int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return (int)Math.max(left, right) + 1;
        }

        public int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            int currDiameter = height(root.left) + height(root.right) + 1;
            return Math.max(currDiameter, Math.max(diameter(root.left), diameter(root.right)));
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.diameter(root)); // 5 & 0(n*2);

        int[] nodes2 = {1, 2, -1, -1, -1};

        BinaryTree tree2 = new BinaryTree();

        Node root2 = tree2.buildTree(nodes2);
        System.out.println(tree2.diameter(root2)); // 2 & 0(n*2);
    }
}