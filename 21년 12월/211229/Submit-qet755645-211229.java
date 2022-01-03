import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ans = 0;
		for (int i = 0; i < 8; i++) {
			String str = scan.next();
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0 && str.charAt(j) == 'F') {
					ans++;
				}
			}
		}
		System.out.println(ans);
		scan.close();
	}
}
