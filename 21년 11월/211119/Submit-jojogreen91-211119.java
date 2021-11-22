import java.util.*;

public class Solution {

    public static void combi (int index, int num, int lv, String str, StringBuilder sb, HashMap<String, Integer> map) {
        if (lv == num) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        } else {
            for (int i = index; i < str.length(); i++) {
                sb.append(str.charAt(i));
                combi(i + 1, num, lv + 1, str, sb, map);

                sb.delete(lv, lv + 1);
            }
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();

            Arrays.sort(arr);

            orders[i] = String.valueOf(arr);
        }

        for (int i = 0; i < course.length; i++) {

            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();

                if (course[i] <= orders[j].length()) {
                    combi(0, course[i], 0, orders[j], sb, map);
                }
            }

            int max = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entries : map.entrySet()) {
                max = Math.max(max, entries.getValue());
            }

            for (Map.Entry<String, Integer> entries : map.entrySet()) {
                if (entries.getValue() == max && max >= 2) {
                    list.add(entries.getKey());
                }
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
