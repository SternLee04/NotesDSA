import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class Topview {
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

        static class Info {
            TreeNode treeNode;
            int distance;

            Info(TreeNode treeNode, int distance) {
                this.treeNode = treeNode;
                this.distance = distance;
            }
        }

        public static void topview(TreeNode root) {
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, TreeNode> map = new HashMap<>();

            int mini = 0, maxi = 0;

            q.add(new Info(root, 0));
            while (!q.isEmpty()) {
                Info curr = q.poll();

                if (!map.containsKey(curr.distance)) {
                    map.put(curr.distance, curr.treeNode);
                }

                if (curr.treeNode.left != null) {
                    q.add(new Info(curr.treeNode.left, curr.distance - 1));
                    mini = Math.min(mini, curr.distance - 1);
                }

                if (curr.treeNode.right != null) {
                    q.add(new Info(curr.treeNode.right, curr.distance + 1));
                    maxi = Math.max(maxi, curr.distance + 1);
                }
            }

            for (int i = mini; i <= maxi; i++) {
                System.out.println(map.get(i).data);
            }
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        int[] arr = { 11, 22, 3, 54, 13, 23, 21 };
        TreeNode root = tree.createTree(arr);
        tree.topview(root);
    }
}