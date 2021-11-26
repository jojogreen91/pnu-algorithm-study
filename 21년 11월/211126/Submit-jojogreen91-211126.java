import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
     public static int rank (int x) {
        int result = 0;

        if (x  == 6) {
            result = 1;
        } else if (x == 5) {
            result = 2;
        } else if (x == 4) {
            result = 3;
        } else if (x == 3) {
            result = 4;
        } else if (x == 2) {
            result = 5;
        } else if (x <= 1) {
            result = 6;
        }

        return result;
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> temp = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int count = 0;
        int zeroCount = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            } else if (temp.contains(lottos[i])) {
                count++;
            }
        }

        int max = count + zeroCount;
        int min = count;
        answer[0] = rank(max);
        answer[1] = rank(min);

        return answer;
    }
}
