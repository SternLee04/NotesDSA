import java.util.*;

public class LLZicZac {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node head = null;

    public void add(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            if (head == null) {
                head = newNode;
                continue;
            }
            newNode.next = head;
            head = newNode;
        }
    }

    public void print(Node head) {
        Node itr = head;
        while (itr != null) {
            System.out.print(itr.val);
            itr = itr.next;
        }
        System.out.println();
    }

    public Node midNode(Node root) {
        Node fast = root.next;
        Node slow = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node reverse(Node root) {
        Node curr = root;
        Node prev = null;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public void ziczac(Node root) {
        if (root == null || root.next == null) {
            return;
        }

        Node mid = midNode(root);
        Node prev = reverse(mid.next);
        mid.next = null;

        Node leftll = root;
        Node rightll = prev;
        Node nextl, nextr;

        while (leftll != null && rightll != null) {
            nextl = leftll.next;
            leftll.next = rightll;
            nextr = rightll.next;
            rightll.next = nextl;

            leftll = nextl;
            rightll = nextr;
        }
    }

    public static void main(String[] args) {
        LLZicZac l1 = new LLZicZac();
        int[] arr = {1, 2, 3, 4, 5, 6};
        l1.add(arr);
        l1.print(l1.head);
        l1.ziczac(l1.head);
        l1.print(l1.head);
    }
}