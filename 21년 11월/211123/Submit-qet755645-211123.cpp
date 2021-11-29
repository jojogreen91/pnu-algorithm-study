#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	bool is_prime[10001];
	for (int i = 1; i < 10001; ++i) is_prime[i] = true;
	
	for (int i = 2; i < 10001; ++i) {
		if (!is_prime[i]) continue;
		int j = 2;
		while (1) {
			if (i*j > 10001) break;
			is_prime[i*j] = false;
			j++;
		}
	}
	
	int N, inp, a, b;
	cin >> N;
	while(N--) {
		cin >> inp;
		for (int i = inp/2; i > 1; i--) {
			a = i;
			b = inp - a;
			if (is_prime[a] and is_prime[b]) {
				cout << a << " " << b << "\n";
				break;
			}
		}
	}
	return 0;
}
