import java.util.*;

/**
 * LaregestBSTinBT
 */
public class LaregestBSTinBT {
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

        /**
         * Solution
         */
        static class Solution {
            static public class Info {
                boolean isBST;
                int size;
                int min;
                int max;

                public Info(boolean isBST, int size, int min, int max) {
                    this.isBST = isBST;
                    this.size = size;
                    this.min = min;
                    this.max = max;
                }
            }

            int maxBST = 0;

            Info largestBST(Node root) {
                if (root == null) {
                    return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
                }

                Info leftInfo = largestBST(root.left);
                Info rightInfo = largestBST(root.right);
                int size = leftInfo.size + rightInfo.size + 1;
                int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
                int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

                if (root.data <= leftInfo.max || root.data >= rightInfo.min) // not valid bst
                    return new Info(false, size, min, max);

                if (leftInfo.isBST && rightInfo.isBST) {
                    maxBST = Math.max(maxBST, size);
                    return new Info(true, size, min, max);
                }

                return new Info(false, size, min, max);
            }
        }

        /**
         * Brutforce
         */
        static class Brutforce {

            Integer Maxsize = 0;

            int largestBST(Node root) {
                traverse(root);
                return Maxsize;
            }

            void traverse(Node root) {
                if (root == null) {
                    return;
                }

                traverse(root.left);
                traverse(root.right);

                if (isValid(root, null, null)) {
                    int height = size(root);
                    Maxsize = Math.max(height, Maxsize);
                }
            }

            boolean isValid(Node root, Node min, Node max) {
                if (root == null)
                    return true;

                if (min != null && root.data <= min.data)
                    return false;
                else if (max != null && root.data >= max.data)
                    return false;

                return isValid(root.left, min, root) && isValid(root.right, root, max);
            }

            int size(Node root) {
                if (root == null)
                    return 0;

                int left = size(root.left);
                int right = size(root.right);

                return left + right + 1;
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        BT tree = new BT();
        root = tree.create(nodes, root);

        BT.Brutforce btBrutforce = new BT.Brutforce();
        int size = btBrutforce.largestBST(root);
        System.out.println(size);

        BT.Solution solution = new BT.Solution();
        solution.largestBST(root);
        System.out.println(solution.maxBST);
    }
}