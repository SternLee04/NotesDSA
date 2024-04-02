import java.util.*;
/**
 * Heap is visulize as spacial CBT but implementation in Array.
 * CBT ( complete binary tree) == completely balaced tree ( but lowest level is not consider mandatory but order of node is consider as mandatory i.e. left to right )
 * 
 * Time complexity :
 * add & delete = O(log n)
 * peek = O(1)
 * 
 * type : minHeap and maxHeap.
 * 
 * minHeap : root is smaller than both children.
 * maxHeap : root is bigger than both children.
 * 
 * example :
 * heap :
 *          2
 *      3       4
 *    5   10  
 * 
 * not heap :
 *          2
 *      3       4
 *    5           10
 * 
 * Properties : 
 * parent -> leftChild : 2 * pareent +1 
 * parent -> rightChild : 2 * pareent +2 
 * children -> parent : (children-1)/2
 */
public class ImplementHeap {

    static class Heap {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void add(int val) {
            arr.add(val);
            
            int child = arr.size()-1;
            int parent = (child-1)/2;

            while (arr.get(child) < arr.get(parent)) { 
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                child = parent;
                parent = (child-1)/2;
            }
        }
        public int peek() { return arr.get(0); }

        // 1. swap root with latest node (0 -> n-1)
        // 2. remove latest node.
        // 3. fix entire heap using hepify.
        public int delete() {
            int root = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, root);

            arr.remove(arr.size()-1);

            heapify(0);
            return root;
        }
        private void heapify(int idx) {// find minimum value from both child (not form subtree) change the parent again for sub level.
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int minIdx = idx;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx))
                minIdx = left;

            if (right < arr.size() && arr.get(right) <  arr.get(minIdx))
                minIdx = right;

            if (minIdx != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        while (! heap.isEmpty()) {
            System.out.println(heap.peek());
            heap.delete();
        }
    }
}