import java.util.*;

class Solution {
    
    public static int solution(int nums) {
        int answer = 0;

        String three = "";
        while (nums / 3 != 0) {
            three = nums % 3 + three;

            nums = nums / 3;
        }
        three = nums + three;

        for (int i = 0; i < three.length(); i++) {
            answer += (int)Math.pow(3, i) * (Integer.valueOf(three.charAt(i)) - 48);
        }

        return answer;
    }
}
