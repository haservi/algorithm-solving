package programmers.Level2.solution._59_점_찍기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int k = 2;
        int d = 4;
        int expectedResult = 6;

        Solution solution = new Solution();
        long result = solution.solution(k, d);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long solution(int k, int d) {
        long answer = 0;
        int limit = d / k;
        for (int i = 0; i <= limit; i++) {
            int x = i * k;
            int maxY = (int) Math.sqrt((long) d * d - (long) x * x);
            int count = (maxY / k) + 1;
            answer += count;
        }
        return answer;
    }
}
