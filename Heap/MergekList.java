import java.util.*;

/**
 * Merge k Sorted Lists
 * hard leetcode.
 * 
 * eg:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [1->4->5,
 * 1->3->4,
 * 2->6]
 * 
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 */
public class MergekList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        // Add all the values from the lists to the priority queue
        for (ListNode node : lists) {
            while (node != null) {
                q.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Construct the new sorted list from the priority queue
        while (!q.isEmpty()) {
            current.next = new ListNode(q.poll());
            current = current.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode ans = mergeKLists(lists);

        while (ans!= null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println("null");
    }
}