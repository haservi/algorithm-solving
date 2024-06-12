package programmers.Level2.solution._47_두_원_사이의_정수_쌍;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;
        long expectedResult = 20;

        Solution solution = new Solution();
        long result = solution.solution(r1, r2);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long solution(int r1, int r2) {
        long answer = 0;

        long r1Squared = (long) r1 * r1;
        long r2Squared = (long) r2 * r2;

        long exactPoints = 0;

        for (long i = 0; i <= r2; i++) {
            long r2YSquared = r2Squared - i * i;
            long r1YSquared = r1Squared - i * i;

            long y2 = (long) Math.sqrt(r2YSquared);
            long y1 = (long) Math.sqrt(r1YSquared);

            if (Math.sqrt(r1YSquared) % 1 == 0) {
                exactPoints++;
            }

            // 4배로 증가(4사분면)
            answer += (y2 - y1) * 4;
        }
        // 경계에 있는 점을 추가하고 원점 중복을 피하기 위해 4를 뺌
        answer += exactPoints * 4 - 4;

        return answer;
    }

}
