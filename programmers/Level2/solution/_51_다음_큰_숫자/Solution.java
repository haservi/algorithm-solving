package programmers.Level2.solution._51_다음_큰_숫자;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 15;
        int expectedResult = 23;

        Solution solution = new Solution();
        int result = solution.solution(n);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n) {
        int nextBit = Integer.bitCount(n);

        while (true) {
            n++;
            if (Integer.bitCount(n) == nextBit) {
                return n;
            }
        }
    }

}
