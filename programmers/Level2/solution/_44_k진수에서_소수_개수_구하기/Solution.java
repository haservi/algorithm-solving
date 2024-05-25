package programmers.Level2.solution._44_k진수에서_소수_개수_구하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(n, k);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public int solution(int n, int k) {
        String[] results = Long.toString(n, k).split("0+");

        int answer = 0;
        for (String value : results) {
            if (isPrime(Long.parseLong(value))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(long value) {
        if (value <= 1) {
            return false;
        }
        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

}
