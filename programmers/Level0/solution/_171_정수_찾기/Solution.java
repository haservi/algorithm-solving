package programmers.Level0.solution._171_정수_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181840?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 15, 98, 23, 2, 15 };
        int n = 20;
        int expectedResult = 0;

        Solution solution = new Solution();
        int result = solution.solution(num_list, n);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] num_list, int n) {
        // 정수 리스트에 n의 값이 있으면 1 없으면 0
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) {
                return 1;
            }
        }
        return 0;
    }
}
