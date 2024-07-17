import java.util.*;

public class CSES4 {

    public static void solve(int[] tickets, int[] customers, int N, int M) {
        TreeMap<Integer, Integer> pendingTickets = new TreeMap<>();// order map 
        
        // Fill the map with tickets and their frequencies
        for (int ticket : tickets) {
            pendingTickets.put(ticket, pendingTickets.getOrDefault(ticket, 0) + 1);
        }

        for (int customer : customers) {
            Integer ticketPrice = pendingTickets.floorKey(customer);
            if (ticketPrice == null) {
                System.out.println(-1);
            } else {
                System.out.println(ticketPrice);
                int count = pendingTickets.get(ticketPrice) - 1;
                if (count == 0) {
                    pendingTickets.remove(ticketPrice);
                } else {
                    pendingTickets.put(ticketPrice, count);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] tickets = new int[N];
        int[] customers = new int[M];

        for (int i = 0; i < N; i++) {
            tickets[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            customers[i] = sc.nextInt();
        }
        solve(tickets, customers, N, M);
    }
}
