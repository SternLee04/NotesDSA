import java.util.LinkedList;
import java.util.Queue;

public class BalenceBT {

    static class Node {

        public int data;
        public Node left;
        public Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Bt {
        public static Node createTree(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            Queue<Node> queue = new LinkedList<>();
            Node root = new Node(arr[0]);
            queue.add(root);

            int i = 1;
            while (!queue.isEmpty() && i < arr.length) {
                Node current = queue.poll();

                // Create left child
                if (i < arr.length) {
                    current.left = new Node(arr[i]);
                    queue.add(current.left);
                    i++;
                }

                // Create right child
                if (i < arr.length) {
                    current.right = new Node(arr[i]);
                    queue.add(current.right);
                    i++;
                }
            }
            return root;
        }

        public static void levelorder(Node root) {
            if (root == null)
                return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.poll();

                System.out.println(curr.data);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        int[] arr = { 11, 22, 3, 54, -1, 23, 21 };
        Node root = tree.createTree(arr);
        tree.levelorder(root);
    }
}