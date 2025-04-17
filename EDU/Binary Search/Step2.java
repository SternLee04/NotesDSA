import java.util.*;

/**
 * Step2
 * Goodbad number :
 * if x is good then x+1 will also good.
 * where x is function that return 1 if good else 0 as bad.
 * 
 * note : answer should look like this on range start to end.
 * 0000000001111111111 not 01010101010.
 * 
 * Structure :
 * 
 * while (l+1 < r) {
 * m = (l+r) /2;
 * if (f(m) == good) {
 * r = m;
 * } else {
 * l = m;
 * }
 * }
 */
public class Step2 {

    public static void main(String[] args) {
        // System.out.println("-------- Packing Rectengles ----------");
        // packingRectangles();
        // System.out.println("-------- Ropes ----------");
        // ropes();
        // System.out.println("--------Very Easy Task ----------");
        // veryEasyTask();
        System.out.println("-------- Children Holiday ----------");
        childrenHoliday();
    }
    static void childrenHoliday() {
        Scanner sc = new Scanner(System.in);
        long ballons = sc.nextLong();
        int assistents = sc.nextInt();
        int[][] assistProps = new int[assistents][3];
        for (int i = 0; i < assistents; i++) {
            assistProps[i][0] = sc.nextInt();
            assistProps[i][1] = sc.nextInt();
            assistProps[i][2] = sc.nextInt();
        }

        long left = 0;
        long right = Integer.MIN_VALUE;// assistent how takes most time to work+tired+rest;
        for (int i = 0; i < assistProps.length; i++) {
            right = Math.max(right, ballons * (assistProps[i][0] + assistProps[i][1] + assistProps[i][2]));
        }

        while (left+1 < right) {
            long mid = left + (right - left)/2;
            if (possibleInflation(ballons, ))
        }
    }
    static void veryEasyTask() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// n copies to print
        int x = sc.nextInt();// copy machin 1
        int y = sc.nextInt();// copy machine 2

        int left = 0;// printing copies in span of zero.
        int right = Math.max(x, y) * n; // printing copies with worst machine.

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (possibleWithTime(mid, n, x, y)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }

    static boolean possibleWithTime(long estimation, long n, long x, long y) {
        if (estimation < Math.min(x,y)) {
            return false; 
        }
        estimation -= Math.min(x,y);// one copy time.
        long cnt = 1;

        cnt += estimation/x + estimation/y;// workdone parallely

        return cnt >= n;
    }

    static void packingRectangles() {
        Scanner sc = new Scanner(System.in);
        long w = sc.nextInt();
        long l = sc.nextInt();
        long n = sc.nextInt();

        long left = 0;// not feasible
        long right = 1;// which extream possible.
        while (!possible(right, n, w, l)) {
            right *= 2;
        }
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (possible(mid, n, w, l)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }

    static boolean possible(long mid, long n, long w, long l) {
        return (mid / w) * (mid / l) >= n;
    }

    static void ropes() {// here answer lies early range of answer is like this 11111110000000. because
                         // x/1 always possible x/infinity == 0 -> ans < k.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            maxLength = Math.max(maxLength, nums[i]);
        }

        double start = 0;
        double end = maxLength;// let say 2,3,4,5 k = 2 then always 2/5 < 2 even 5/5 == 1 < 2
        for (int i = 0; i < 100; i++) {// note that we didn't do traditional left pointer goes beyon right then exit
                                       // loop.
            double mid = start + (end - start) / 2;// instead we constantly do same thing 100 times.
            if (checkAllRopes(nums, k, mid)) {
                start = mid;// we want maximus start is used.
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    static boolean checkAllRopes(int[] nums, int k, double x) {
        int count = 0;
        for (int num : nums) {
            count += Math.floor(num / x);
        }
        return count >= k;
    }
}