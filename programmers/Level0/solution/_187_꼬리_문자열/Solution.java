package programmers.Level0.solution._187_꼬리_문자열;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181841?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] strList = {"abc", "def", "ghi"};
        String ex = "ef";
        String expectedResult = "abcghi";

        Solution solution = new Solution();
        String result = solution.solution(strList, ex);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();

        for (String str : str_list) {
            if (!str.contains(ex)) {
                answer.append(str);
            }
        }

        return answer.toString();
    }
}
