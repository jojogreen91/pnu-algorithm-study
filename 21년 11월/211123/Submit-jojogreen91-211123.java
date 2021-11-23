import java.util.*;
import java.io.*;

public class Main {

    static boolean[] prime = new boolean[10001]; // 0 ~ 10000

    static void getPrime () {
        prime[0] = true;
        prime[1] = true;

        for (int i = 0; i <= Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                for (int j = i*i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        // 소수는 false
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        getPrime();

        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            int targetNum = Integer.parseInt(br.readLine()); // 짝수

            for (int j = targetNum/2; j > 0; j--) {
                if (!prime[j]) {
                    int index = targetNum - j;
                    if (!prime[index]) {
                        System.out.println(j + " " + index);
                        break;
                    }
                }
            }
        }
    }
}
