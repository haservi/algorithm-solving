package programmers.Level0.solution._73_글자_이어_붙여_문자열_만들기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181915?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "cvsgiorszzzmrpaqpe";
        int[] index_list = { 16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7 };
        String expectedResult = "programmers";

        Solution solution = new Solution();
        String result = solution.solution(my_string, index_list);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();
        for (int i : index_list) {
            answer.append(my_string.charAt(i));
        }
        return answer.toString();
    }
}
