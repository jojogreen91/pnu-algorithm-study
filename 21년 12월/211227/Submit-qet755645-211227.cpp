#include <iostream>
#include <stack>
#include <string>
#include <sstream>
using namespace std;


int main(){
	int N, buf;
	std::ios::sync_with_stdio(false);
	
	cin >> N;
	
	stack<int> s;
	
	while(N--){
		cin >> buf; 
		if (buf == 0) s.pop();
		else s.push(buf);
	}
	
	int sum = 0;
	N = s.size();
	while(N--){
		sum += s.top();
		s.pop();
	}
	cout << sum;
	return 0;
}
