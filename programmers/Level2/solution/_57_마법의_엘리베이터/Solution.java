package programmers.Level2.solution._57_마법의_엘리베이터;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int storey = 16;
        int expectedResult = 6;

        Solution solution = new Solution();
        int result = solution.solution(storey);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int remain = storey % 10;
            storey = storey / 10;

            if (remain < 5) {
                answer += remain;
            } else if (5 < remain) {
                answer += (10 - remain);
                // 다음 자리수를 하나 올림
                storey += 1;
            } else {
                if (storey % 10 >= 5) {
                    answer += (10 - remain);
                    // 다음 자리수를 하나 올림
                    storey += 1;
                } else {
                    answer += remain;
                }
            }
        }

        return answer;
    }

}
