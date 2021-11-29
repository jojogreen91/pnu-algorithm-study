class Solution {
    public static long solution(long w, long h) {
        long result = 0;

        for (int i = 0; i < w; i++) {
            result += (h * i) / w;
        }

        return result * 2;
    }
}
