import java.util.*;
/**
 * Merge2BST: if you know how use Inorder array to make bst.
 * 
 * get both inorder Array.
 * the merge it, sort it.
 * make bst.
 */
public class Merge2BST {
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

        Node merge(Node root, Node root2) {
            ArrayList<Integer> inorderList = new ArrayList<>();
            ArrayList<Integer> inorderList2 = new ArrayList<>();

            inorderSequence(root, inorderList);
            inorderSequence(root2, inorderList2);

            for (Integer node : inorderList2) inorderList.add(node);

            Collections.sort(inorderList);

            return createBST(inorderList, 0, inorderList.size()-1);
        }
        void inorderSequence(Node root, ArrayList<Integer> list) {
            if (root == null) return;

            inorderSequence(root.left, list);
            list.add(root.data);
            inorderSequence(root.right, list);
        }
        Node createBST(ArrayList<Integer> nodes, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;
            Node rootNode = new Node(nodes.get(mid));
            rootNode.left = createBST(nodes, left, mid-1);
            rootNode.right = createBST(nodes, mid+1, right);

            return rootNode;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 6, 10, 11, 14 };
        int nodes2[] = { 9, 6, 4, 7, 11, 12, 15};
        Node root = null;
        Node root2 = null;
        BT tree = new BT();
        BT tree2 = new BT();
        root = tree.create(nodes, root);
        root2 = tree2.create(nodes2, root2);

        Node mergedBST = tree.merge(root, root2);
        System.out.println(mergedBST.data);
    }
}