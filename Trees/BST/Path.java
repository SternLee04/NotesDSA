import java.util.*;
public class Path {
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

        void rootLeaf(Node root, ArrayList<Integer> path) {
            if (root == null) {
                return;
            }
            
            path.add(root.data);

            if (root.left == null && root.right == null) {
                for (Integer list : path) {
                    System.out.print(list + " ");
                }
                System.out.println();
            }

            rootLeaf(root.left, path);
            rootLeaf(root.right, path);
            path.remove(path.size() -1);
        }

        void allPath(Node root, ArrayList<Integer> path) {
            if (root == null) {
                return;
            }

            path.add(root.data);
            allPath(root.left, path);

            for (Integer itr : path) {
                System.out.print(itr + " ");
            }
            System.out.println();

            allPath(root.right, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        tree.rootLeaf(root, new ArrayList<Integer>());
        System.out.println("-------------------------");
        tree.allPath(root , new ArrayList<Integer>());
    }
}