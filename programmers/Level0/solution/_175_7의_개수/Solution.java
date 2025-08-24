package programmers.Level0.solution._175_7의_개수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120912?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] array = { 7, 77, 17 };
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution(array);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] array) {
        int answer = 0;
        for (int n : array) {
            while (n > 0) {
                if (n % 10 == 7) {
                    answer++;
                }
                n /= 10;
            }
        }
        return answer;
    }
}
