package programmers.Level0.solution._59_이어_붙인_수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181928?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 3, 4, 5, 2, 1 };
        int expectedResult = 393;

        Solution solution = new Solution();
        int result = solution.solution(num_list);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] num_list) {
        int evenSum = 0;
        int oddSum = 0;

        for (int num : num_list) {
            if (num % 2 == 0) {
                evenSum = evenSum * 10 + num;
            } else {
                oddSum = oddSum * 10 + num;
            }
        }

        return evenSum + oddSum;
    }
}
