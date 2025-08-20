package programmers.Level0.solution._174_다음에_올_숫자;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120924?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] common = { 1, 2, 3, 4 };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(common);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] common) {
        int diff1 = common[1] - common[0];
        int diff2 = common[2] - common[1];

        if (diff1 == diff2) {
            // 등차수열: 마지막 원소 + 공차
            return common[common.length - 1] + diff1;
        } else {
            // 등비수열: 마지막 원소 * 공비
            return common[common.length - 1] * (common[1] / common[0]);
        }
    }
}
