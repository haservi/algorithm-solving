package programmers.Level0.solution._113_첫_번째로_나오는_음수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181896?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 12, 4, 15, 46, 38, -2, 15 };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(num_list);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
