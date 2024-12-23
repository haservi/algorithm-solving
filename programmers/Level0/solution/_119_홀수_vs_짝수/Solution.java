package programmers.Level0.solution._119_홀수_vs_짝수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181887?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 4, 2, 6, 1, 7, 6 };
        int expectedResult = 17;

        Solution solution = new Solution();
        int result = solution.solution(num_list);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                even += num_list[i];
            } else {
                odd += num_list[i];
            }
        }
        return Math.max(even, odd);
    }

}
