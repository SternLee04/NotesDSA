import java.util.*;

public class DoubllyReverse {
    
    public static class Node {
        int val;
        Node next;
        Node prev;
        
        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void add(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            addFirst(arr[i]);
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

    public Node reverse(Node head) {
        Node prevNode = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prevNode;
            curr.prev = nextNode;
            prevNode = curr;
            curr = nextNode;
        }

        head = prevNode;

        return head;
    }

    public static void main(String[] args) {
        DoubllyReverse ll = new DoubllyReverse();
        int[] arr = {1, 2, 3, 4, 5, 6};
        ll.add(arr);
        ll.print(ll.head);
        ll.head = ll.reverse(ll.head);
        ll.print(ll.head);
    }
}