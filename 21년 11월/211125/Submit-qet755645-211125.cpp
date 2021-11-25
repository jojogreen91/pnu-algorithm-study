#include <iostream>
#include <queue>

using namespace std;

int main(){
	int T, N, M;
	typedef pair<int, int> file;
	
	cin >> T;
	while(T--){
		cin >> N >> M;
		
		queue<file> q;
		priority_queue<int> pq;
		
		for (int i = 0; i < N; i++){
			int prior;
			cin >> prior;
			q.push(make_pair(i, prior));
			pq.push(prior);
		}
		int ans = 0;
		while(!q.empty()){
			if (q.front().second == pq.top()){
				ans ++;
				if (q.front().first == M){
					cout << ans << endl;
					break;
				}
				q.pop();
				pq.pop();
			}
			else {
				q.push(q.front());
				q.pop();
			}
		}
	}
	return 0;
}
