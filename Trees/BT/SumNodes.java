import java.util.*;

public class SumNodes {
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

        int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int leftsum = sum(root.left);
            int rightsum = sum(root.right);
            return leftsum + rightsum + root.data;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.sum(root));

        int[] nodes2 = {1,2,-1,-1,-1};
        BinaryTree tree2 = new BinaryTree();
        Node root2 = tree2.buildTree(nodes2);
        System.out.println(tree2.sum(root2));
    }
}