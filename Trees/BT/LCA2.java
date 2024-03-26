import java.util.LinkedList;
import java.util.Queue;

public class LCA2 {
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

        public static TreeNode lastCommonAncestor(TreeNode root, int a, int b) {
            if (root == null || root.data == a || root.data == b) {
                return root;
            }

            TreeNode leftLca = lastCommonAncestor(root.left, a, b);
            TreeNode rightLca = lastCommonAncestor(root.right, a, b);

            if (rightLca == null) {
                return leftLca;
            }

            if (leftLca == null) {
                return rightLca;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = tree.createTree(arr);
        TreeNode ans = tree.lastCommonAncestor(root, 5, 4);
        System.out.println(ans.data);
    }
}