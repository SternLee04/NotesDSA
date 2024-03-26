import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LCA {
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

        public static boolean commonAncestors(TreeNode root, int node, ArrayList<TreeNode> path) {
            if (root == null)
                return false;

            path.add(root);

            if (root.data == node)
                return true;

            boolean foundLeft = commonAncestors(root.left, node, path);
            boolean foundRight = commonAncestors(root.right, node, path);

            if (foundLeft || foundRight)
                return true;

            path.remove(path.size() - 1);
            return false;
        }

        public static TreeNode lastCommonAncestor(TreeNode root, int a, int b) {

            TreeNode ans = null;

            ArrayList<TreeNode> pathA = new ArrayList<>();
            ArrayList<TreeNode> pathB = new ArrayList<>();
            commonAncestors(root, a, pathA);
            System.out.println();

            commonAncestors(root, b, pathB);

            for (int i = 0; i < pathA.size() && i < pathB.size(); i++) {
                if (pathA.get(i) == pathB.get(i)) {
                    ans = pathA.get(i);
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        int[] arr = { 11, 22, 3, 54, 13, 23, 21 };
        TreeNode root = tree.createTree(arr);
        TreeNode ans = tree.lastCommonAncestor(root, 54, 13);
        System.out.println(ans.data);
        System.out.println();
    }

}