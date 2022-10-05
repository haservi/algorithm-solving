package programmers.Level0.solution._25_문자열안에_문자열;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120908
 */
public class Solution {

    public static void main(String[] args) {
        String str1 = "ab6CDE443fgh22iJKlmn1o";
        String str2 = "6CD";

        Solution solution = new Solution();
        int result = solution.solution(str1, str2);
        System.out.println("result: " + result);
    }

    public int solution(String str1, String str2) {
        if (str1.contains(str2)) {
            return 1;
        }
        return 2;
    }
}
