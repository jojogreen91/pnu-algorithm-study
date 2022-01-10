import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		loopOut:
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					// System.out.printf("%d %d %d : %d \n", i, j, k, sum);
					if (sum > max && sum <= M) max = sum;
					if (sum == M) break loopOut;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
}
