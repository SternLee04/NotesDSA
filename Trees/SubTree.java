import java.util.*;

public class SubTree {
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

        public boolean identical(treeNode root, treeNode sub) {
            if (root == null && sub == null)
                return true;

            if (root == null || sub == null) {
                return false;
            } else if (root.data != sub.data) {
                return false;
            }

            boolean leftEqual = identical(root.left, sub.left);
            boolean rightEqual = identical(root.right, sub.right);

            return leftEqual && rightEqual;
        }

        public boolean contains(treeNode root, treeNode sub) {
            if (root == null) {
                return false;
            }
            if (root.data == sub.data)
                return identical(root, sub);

            boolean leftSide = contains(root.left, sub);
            boolean rightSide = contains(root.right, sub);

            return leftSide || rightSide;
        }
    }
    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        treeNode root = tree.build(nodes);

        int[] subNodes = { 2, 4, -1, -1, 5, -1, -1 };
        BinaryTree subtree = new BinaryTree();

        treeNode subRoot = subtree.build(subNodes);

        System.out.println(tree.contains(root, subRoot));
    }
}