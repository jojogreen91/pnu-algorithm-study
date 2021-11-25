import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Print {
        int tag;
        int value;

        public Print(int tag, int value) {
            this.tag = tag;
            this.value = value;
        }
    }

    static int solution(int lineNum, int place, int[] arr) {
        int answer = 0;

        Queue<Print> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Print(i, arr[i]));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            Print poll = queue.poll();

            boolean check = true;
            for (Print p : queue) {
                if (poll.value < p.value) {
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;

                if (poll.tag == place) {
                    return count;
                }
            } else {
                queue.offer(poll);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            StringTokenizer stz1 = new StringTokenizer(br.readLine());
            int lineNum = Integer.parseInt(stz1.nextToken());
            int place = Integer.parseInt(stz1.nextToken());

            StringTokenizer stz2 = new StringTokenizer(br.readLine());
            int[] arr = new int[lineNum];
            for (int j = 0; j < lineNum; j++) {
                arr[j] = Integer.parseInt(stz2.nextToken());
            }

            System.out.println(solution(lineNum, place, arr));
        }
    }
}
