#include <iostream>
using namespace std;

int sum(int num) {
	int sum = 0, i = 0, j = 0, k = 0;
	while (i != num) {
		j++;
		k = 0;
		while(j != k) {
			i++, k++;
			sum += j;
			if(i == num) break;
		}
	}
	return sum;
}

int main() {
	int n1, n2;
	cin >> n1 >> n2;
	cout << sum(n2) - sum(n1-1);
	return 0;
}
