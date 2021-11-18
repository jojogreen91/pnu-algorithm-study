import java.util.*;

public class Solution {

    static int cnt = 0;

    public static void dfs(int lv, int[] numbers, int target, int sum) {
        if (lv == numbers.length) {
            if (sum == target) {
                cnt++;
            }
        } else {
            dfs(lv + 1, numbers, target, sum + numbers[lv]);
            dfs(lv + 1, numbers, target, sum - numbers[lv]);
        }
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0, numbers, target, 0);

        answer = cnt;
        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }
}
