import java.util.*;
/**
 * We are given an m x n binary matrix of 1's (soldiers) and O's (civilians). 
 * The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * 
 * A row i is weaker than a row j if one of the following is true:
 *  • The number of soldiers in row i is less than the number of soldiers in row i.
 *  • Both rows have the same number of soldiers and i < j.
 * 
 * Find the K weakest rows.
 */
public class WeakestSoldier {
    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        public Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override 
        public int compareTo(Row r2) {// checking multiple comparisons.
            if (this.soldiers == r2.soldiers) {
                return this.index - r2.index;
            }
            return this.soldiers - r2.soldiers;
        }   
    }
    public static void main(String[] args) {
        int[][] army = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},};
        int K = 2;

        PriorityQueue<Row> formation = new PriorityQueue<Row>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[i].length; j++) {
                count += army[i][j] == 1 ? 1 : 0 ;
            }
            formation.add(new Row(count, i));
        }

        for (int i = 0; i < K; i++) {
           System.out.println("R" + formation.remove().index); 
        }
    }
}
