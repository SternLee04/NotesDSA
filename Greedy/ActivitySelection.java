import java.util.*;
/*
 * You are given n activities with their start and end times.
 * Select the maximum number of activities that can be performed by a single person, 
 * assuming that a person can only work on a single activity at a time.
 * Activities are sorted according to end time.
 * 
 * Best way to get more activities is pick activities that are disjoint.
 * faster the activity end more activities can be done
 */
public class ActivitySelection {
    public static void unsorted(int[] start, int[] end) {
        // make 2d array of n x 3
        int[][] mapped = new int[6][3];
        for (int i = 0; i < start.length; i++) {
            mapped[i][0] = i;
            mapped[i][1] = start[i];
            mapped[i][2] = end[i];
        }

        Arrays.sort(mapped, Comparator.comparing(o -> o[2]));// lamda function 

        int count = 1;
        int lastEnd = mapped[0][2];
        for (int i = 1; i < mapped.length; i++) {
            if (mapped[i][1] >= lastEnd) {
                count++;
                lastEnd = mapped[i][2];
                System.out.print(mapped[i][0] + " ");
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> activities = new ArrayList<ArrayList<Integer>>();
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        int count = 1;// first activity always execute
        int lastEnd = end[0];
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) {
                count++;
                lastEnd = end[i];
                System.out.print(i + " ");
            }
        }
        System.out.println(count);

        unsorted(start, end);
    }
}
