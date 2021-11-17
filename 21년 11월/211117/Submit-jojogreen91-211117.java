import java.util.*;

public class Solution {

    public static String solution(String new_id) {
        String answer = "";

        // 1단계
        String newStr1 = new_id.toLowerCase();

        // 2단계
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < newStr1.length(); i++) {
            Character c = newStr1.charAt(i);

            if (c.equals('-') || c.equals('_') || c.equals('.') || Character.isLowerCase(c) || Character.isDigit(c)) {
                sb2.append(c);
            }
        }
        String newStr2 = sb2.toString();

        // 3단계
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < newStr2.length(); i++) {
            Character c = newStr2.charAt(i);

            if (!stack.isEmpty() && stack.peek().equals('.') && c.equals('.')) {
                continue;
            } else {
                stack.push(c);
            }
        }

        // 4단계
        StringBuilder sb4 = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Character c = stack.get(i);

            if (i == 0 && c.equals('.')) {
                continue;
            } else if (i == size - 1 && c.equals('.')) {
                continue;
            } else {
                sb4.append(c);
            }
        }
        String newStr4 = sb4.toString();

        // 5단계 결과
        String newStr5 = newStr4.replace(" ", "a");
        if (newStr4.length() == 0) {
            newStr5 = "a";
        }

        // 6단계
        if (newStr5.length() >= 16) {
            StringBuilder sb6 = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                Character c = newStr5.charAt(i);

                if (i == 14 && c.equals('.')) {
                    continue;
                } else {
                    sb6.append(c);
                }
            }
            String newStr6 = sb6.toString();

            answer = newStr6;
        // 7단계
        } else if (newStr5.length() <= 2) {
            while (newStr5.length() != 3) {
                char c = newStr5.charAt(newStr5.length() - 1);
                newStr5 += c;
            }
            String newStr7 = newStr5;

            answer = newStr7;
        } else {
            answer = newStr5;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

