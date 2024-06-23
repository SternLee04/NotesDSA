import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

/*

n merges


111

1 | 101 | 101 | 10 | 01|1
10 2 5 2 10
1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1 2 1 1 1 1

Cut parts 11 7 11

+11 -7 +11

Sum of numbers <= 2e5

//can start with any prefix sum, you want the smallest max prefix sum
dp[prefixSum][index]
   2e5        2e5


 */
public class Main {

	public static void main(String[] subscribeToSecondThread) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			int n = fs.nextInt();
			char[] a = fs.next().toCharArray();
			ArrayList<Integer> list = new ArrayList<>();
			char last = a[0], count = 0;
			for (char c : a) {
				if (c == last)
					count++;
				else {
					if (count % 2 == 0) {
						list.add(2);
					} else {
						list.add(1);
					}
					count = 1;
					last = c;
				}
			}
			if (count % 2 == 0) {
				list.add(2);
			} else {
				list.add(1);
			}

			ArrayList<Integer> sizes = new ArrayList<>();
			int cur = 0;
			for (int i : list) {
				if (i == 2) {
					cur++;
					sizes.add(cur);
					cur = 1;
				} else {
					cur++;
				}
			}
			sizes.add(cur);
			// System.out.println(sizes);

			// TODO: solve with sizes somehow?
			int max = 0, min = 0;
			cur = 0;
			for (int i = 0; i < sizes.size(); i++) {
				if (i % 2 == 0) {
					cur += sizes.get(i);
				} else {
					cur -= sizes.get(i);
				}
				max = Math.max(cur, max);
				min = Math.min(cur, min);
			}

			out.println(max - min);
		}
		out.close();
	}

	static final Random random = new Random();
	static final int mod = 1_000_000_007;

	static void ruffleSort(int[] a) {
		int n = a.length;// shuffle, then sort
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}

	static long add(long a, long b) {
		return (a + b) % mod;
	}

	static long sub(long a, long b) {
		return ((a - b) % mod + mod) % mod;
	}

	static long mul(long a, long b) {
		return (a * b) % mod;
	}

	static long exp(long base, long exp) {
		if (exp == 0)
			return 1;
		long half = exp(base, exp / 2);
		if (exp % 2 == 0)
			return mul(half, half);
		return mul(half, mul(half, base));
	}

	static long[] factorials = new long[2_000_001];
	static long[] invFactorials = new long[2_000_001];

	static void precompFacts() {
		factorials[0] = invFactorials[0] = 1;
		for (int i = 1; i < factorials.length; i++)
			factorials[i] = mul(factorials[i - 1], i);
		invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
		for (int i = invFactorials.length - 2; i >= 0; i--)
			invFactorials[i] = mul(invFactorials[i + 1], i + 1);
	}

	static long nCk(int n, int k) {
		return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
	