import java.util.*;
/**
 * ConnectNRopes
 * Given are N ropes of different lengths,
 * the task is to connect these ropes into one rope with minimum cost, 
 * such that the cost to connect two ropes is equal to the sum of their lengths.
 * 
 * ropes 4,3,2,6 ans = 29
 * 
 * 2 + 3 = 5 
 * 5 + 4 = 9 
 * 9 + 6 = 15 
 * 
 * 5 + 9 + 15 = 29
 * 
 * this not greedy we peeking cheapest pair of rope and combining 
 * and put cost inside PQ.
 */
public class ConnectNRopes {

    public static void main(String[] args) {
        int[] ropes = {2,3,3,4,6};
        PriorityQueue<Integer> minCost = new PriorityQueue<>();
        int totalCost = 0;

        for (int i = 0; i < ropes.length; i++) {
            minCost.add(ropes[i]);
        }

        while ( minCost.size() > 1) {
            int ropeCost1 = minCost.remove();
            int ropeCost2 = minCost.remove();

            int cost = ropeCost1 + ropeCost2;
            minCost.add(cost);
            
            totalCost += cost;
        }

        System.out.println(totalCost);
    }
    /*
     * 2 + 3 = 5
     * 3 + 4 = 7
     * 5 + 6 = 11
     * 7 + 11 = 18
     * 
     * 5 + 7 + 11 + 18 = 41
     */
}