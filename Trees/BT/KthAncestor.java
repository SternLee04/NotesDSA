import java.util.LinkedList;
import java.util.Queue;

public class KthAncestor {
    static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Bt {
        public static TreeNode createTree(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(arr[0]);
            queue.add(root);

            int i = 1;
            while (!queue.isEmpty() && i < arr.length) {
                TreeNode current = queue.poll();

                if (i < arr.length) {
                    current.left = new TreeNode(arr[i]);
                    queue.add(current.left);
                    i++;
                }

                if (i < arr.length) {
                    current.right = new TreeNode(arr[i]);
                    queue.add(current.right);
                    i++;
                }
            }

            return root;
        }

        public static void print(TreeNode root) {
            if (root == null) {
                return;
            }
            print(root.left);
            print(root.right);
            System.out.println(root.data);
        }

        public static TreeNode lastcommonAncester(TreeNode root, int a, int b) {
            if (root == null || root.data == a || root.data == b) {
                return root;
            }

            TreeNode leftLca = lastcommonAncester(root.left, a, b);
            TreeNode rightLca = lastcommonAncester(root.right, a, b);

            if (rightLca == null) {
                return leftLca;
            }

            if (leftLca == null) {
                return rightLca;
            }

            return root;
        }

        public static int kthAncester(TreeNode root, int k, int node) {
            if (root == null)
                return -1;

            if (root.data == node) {
                return 0;
            }

            int leftside = kthAncester(root.left, k, node);
            int rightside = kthAncester(root.right, k, node);

            if (leftside == -1 && rightside == -1) {
                return -1;
            }

            int maxi = Math.max(leftside, rightside);

            if (maxi + 1 == k) {
                System.out.println(root.data);
            }

            return maxi + 1;
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = tree.createTree(arr);
        tree.kthAncester(root, 1, 4);
    }
}