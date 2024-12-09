package programmers.Level0.solution._112_가까운_1_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181898?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 1 };
        int idx = 1;
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(arr, idx);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
