import java.util.*;

public class DiameterOptimize {
    public static class treeNode {

        int data;
        treeNode left;
        treeNode right;

        treeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        
        public int idx = -1;

        public treeNode build(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            treeNode newNode = new treeNode(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;
        }
        public static class Info {

            int diameter;
            int height;

            Info(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }

        public Info diameter2(treeNode root) {// 0(n)
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int currdiameter = leftInfo.height + rightInfo.height + 1;
            int diameter = Math.max(currdiameter, Math.max(leftInfo.diameter, rightInfo.diameter));
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;

            return new Info(diameter, height);
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        treeNode root = tree.build(nodes);
        System.out.println((tree.diameter2(root)).diameter);
    }
}