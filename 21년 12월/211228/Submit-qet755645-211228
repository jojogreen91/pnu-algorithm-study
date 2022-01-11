import java.util.Scanner;

public class Main {
	static int N, M, r, c, d;

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
			
			int[] frontPos = getFront(r, c, d);
			int[] backPos = getBack(r, c, d);
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
	
	static int[] getFront(int _x, int _y, int _z) {
		int[] ret= new int[2];
		switch(_z) {
			case 0:
				ret[0] = _x - 1;
				ret[1] = _y;
				break;
			case 1:
				ret[0] = _x;
				ret[1] = _y + 1;
				break;
			case 2:
				ret[0] = _x + 1;
				ret[1] = _y;
				break;
			case 3:
				ret[0] = _x;
				ret[1] = _y - 1;
				break;
		}
		return ret;
	}
	static int[] getBack(int _x, int _y, int _z) {
		int[] ret= new int[2];
		switch(_z) {
			case 0:
				ret[0] = _x + 1;
				ret[1] = _y;
				break;
			case 1:
				ret[0] = _x;
				ret[1] = _y - 1;
				break;
			case 2:
				ret[0] = _x - 1;
				ret[1] = _y;
				break;
			case 3:
				ret[0] = _x;
				ret[1] = _y + 1;
				break;
		}
		return ret;
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
