import java.util.*;
/**
 * Heap sort - O(log n)
 * ascending order - maxHeap
 * descending order - minHeap
 * 
 */
public class HeapSort {
    static class Heap {

        static ArrayList<Integer> arr = new ArrayList<>();

        static private void heapify(int idx, int size) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int maxIdx = idx;

            if (left < size && arr.get(left) > arr.get(maxIdx))
                maxIdx = left;

            if (right < size && arr.get(right) > arr.get(maxIdx))
                maxIdx = right;

            if (maxIdx != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(maxIdx));
                arr.set(maxIdx, temp);
                heapify(maxIdx, size);
            }
        }

        static ArrayList<Integer> heapsort(ArrayList<Integer> a) {
            arr = a;

            for (int i = arr.size()/2; i >= 0; i--) {
                heapify(i, arr.size());
            }

            for (int i = arr.size()-1; i > 0; i--) {
                int temp = arr.get(0);
                arr.set(0, arr.get(i));
                arr.set(i, temp);
                heapify(0, i);
            }

            return arr;
        }
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);

        System.out.println(Heap.heapsort(list));
    }
}