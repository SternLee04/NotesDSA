#include <iostream>
#include <map>
#include <vector>
using namespace std;

void solve(vector<int>& tickets, vector<int>& customers, int N, int M) {
    map<int, int> pendingTickets; // ordered map

    // Fill the map with tickets and their frequencies
    for (int ticket : tickets) {
        pendingTickets[ticket]++;
    }

    for (int customer : customers) {
        auto it = pendingTickets.upper_bound(customer);
        if (it == pendingTickets.begin()) {
            cout << -1 << endl;
        } else {
            --it;
            cout << it->first << endl;
            it->second--;
            if (it->second == 0) {
                pendingTickets.erase(it);
            }
        }
    }
}

int main() {
    int N, M;
    cin >> N >> M;
    vector<int> tickets(N);
    vector<int> customers(M);

    for (int i = 0; i < N; i++) {
        cin >> tickets[i];
    }
    for (int i = 0; i < M; i++) {
        cin >> customers[i];
    }

    solve(tickets, customers, N, M);
    return 0;
}
