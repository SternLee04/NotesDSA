import java.util.*;

public class MergeSort {
    
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
    
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = midNode(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        
        head = merge(newLeft, newRight);
        return head;
    }
    
    public Node merge(Node firstHalf, Node secondHalf) {
        Node temp = new Node(-1);
        Node newHead = temp;
        
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val <= secondHalf.val) {
                temp.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                temp.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            temp = temp.next;
        }
        
        while (firstHalf != null) {
            temp.next = firstHalf;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        
        while (secondHalf != null) {
            temp.next = secondHalf;
            secondHalf = secondHalf.next;
            temp = temp.next;
        }
        
        return newHead.next;
    }
    
    public static void main(String[] args) {
        MergeSort l1 = new MergeSort();
        int[] arr = {1, 2, 3, 4, 5};
        l1.add(arr);
        l1.print(l1.head);
        l1.head = l1.mergeSort(l1.head);
        l1.print(l1.head);
    }
}