import java.util.Queue;
import java.util.LinkedList;

public class KthLevel {
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

        public static void kthBFS(TreeNode root, int k) {
            Queue<TreeNode> q = new LinkedList<>();

            q.add(root);
            q.add(null);
            int level = 1;
            while (!q.isEmpty()) {
                TreeNode curr = q.remove();
                if (curr == null) {
                    level++;
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (level == k) {
                        System.out.println(curr.data);
                    }
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public static void kthDFS(TreeNode root, int k) {
            if (root == null)
                return;

            if (k == 1) {
                System.out.println(root.data);
                return;
            }

            kthDFS(root.left, k - 1);
            kthDFS(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        int[] arr = {11, 22, 3, 54, 13, 23, 21};
        TreeNode root = tree.createTree(arr);
        // tree.kthBFS(root, 3);
        tree.kthDFS(root, 3);
    }
}