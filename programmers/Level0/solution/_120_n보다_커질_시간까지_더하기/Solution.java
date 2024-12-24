package programmers.Level0.solution._120_n보다_커질_시간까지_더하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181884?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = { 34, 5, 71, 29, 100, 34 };
        int n = 123;
        int expectedResult = 139;

        Solution solution = new Solution();
        int result = solution.solution(numbers, n);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] numbers, int n) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (n < answer) {
                break;
            }
            answer += numbers[i];
        }
        return answer;
    }

}
