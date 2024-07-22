import java.util.*;
/**
 * Playlist
 * leetcode : Longest Substring Without Repeating Characters 
 */
public class Playlist {

    static int solve(int[] songs, int n) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!set.contains(songs[right])) {
                set.add(songs[right]);
                // maxLength = Math.max(maxLength, right - left + 1); 
                maxLength = Math.max(set.size(), maxLength);
            } else {
                while (set.contains(songs[right])) {
                    set.remove(songs[left]);
                    left++;
                }
                set.add(songs[right]);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] songs = new int[n];
        for (int i = 0; i < songs.length; i++) {
            songs[i] = sc.nextInt();
        }

        int ans = solve(songs, n);
        System.out.println(ans);
    }
}