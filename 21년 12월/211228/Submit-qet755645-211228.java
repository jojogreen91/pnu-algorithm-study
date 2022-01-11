import java.util.Scanner;

public class Main {
	static int N, M, r, c, d;
	static int[][] direction= {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
	static void clean(int[][] map) {
		boolean flag = true;
		int ans = 0;
		int cnt = 0;
		while(true) {
			// *** step 1 ***
			if (flag) {
				map[r][c] = 2;
				ans++;
				cnt = 0;
			}
			// *** step 2 - a ***
			d = (d + 3) % 4; // rotate
			
			int[] frontPos = {r + direction[d][0], c + direction[d][1]};
			int[] backPos = {r - direction[d][0], c - direction[d][1]};
			
			if (map[frontPos[0]][frontPos[1]] == 0) {
				flag = true;
				r = frontPos[0];
				c = frontPos[1];
				continue;
			}
			// *** step 2 -b ***
			cnt++;
			flag = false;
			// *** step 2 - c ***
			if (cnt == 4 && map[backPos[0]][backPos[1]] != 1) {
				r = backPos[0];
				c = backPos[1];
				cnt = 0;
			}
			else if (cnt == 4){
				System.out.println(ans);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		clean(map);
		sc.close();
	}
}
