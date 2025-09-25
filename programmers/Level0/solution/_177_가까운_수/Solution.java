package programmers.Level0.solution._177_가까운_수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120890?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] array = { 3, 10, 28 };
        int n = 20;
        int expectedResult = 28;

        Solution solution = new Solution();
        int result = solution.solution(array, n);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] array, int n) {
        int answer = array[0];
        int minDiff = Math.abs(array[0] - n);

        for (int i = 1; i < array.length; i++) {
            int currentDiff = Math.abs(array[i] - n);

            if (currentDiff < minDiff
                    || (currentDiff == minDiff && array[i] < answer)) {
                answer = array[i];
                minDiff = currentDiff;
            }
        }

        return answer;
    }
}
