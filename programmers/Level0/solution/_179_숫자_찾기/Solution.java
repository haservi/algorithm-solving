package programmers.Level0.solution._179_숫자_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120904?language=java
 */
class Solution {

    public static void main(String[] args) {
        int num = 232443;
        int k = 4;
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution(num, k);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        String target = String.valueOf(k);

        int index = numStr.indexOf(target);
        return index == -1 ? -1 : index + 1;
    }
}
