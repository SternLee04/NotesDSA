import java.util.*;
/**
 * MovieFestival
 * 
 * in order to watch maximum number of movies. we have sort on end time.
 * movies end quickly we quickly start next movie so this leads max count of movies.
 */
public class MovieFestival {

    static long solve(int n, int[][] movies) {
        Arrays.sort(movies, (a, b) -> a[1] - b[1]);// sort on end time.
        long totalWatched = 0;
        long currentEnd = 0;

        for (int i = 0; i < n; i++) {
            if (movies[i][0] >= currentEnd) {
                totalWatched++;
                currentEnd = movies[i][1];
            } 
        }

        return totalWatched;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] movies = new int[n][2];

        for (int i = 0; i < n; i++) {
            movies[i][0] = scanner.nextInt();
            movies[i][1] = scanner.nextInt();
        }

        long ans = solve(n , movies);
        System.out.println(ans);
    }
}