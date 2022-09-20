package programmers.Level2.solution._20_JadenCase_문자열_만들기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
public class Solution {

    public static void main(String[] args) {

        String s = "3people unFollowed me";

        Solution solution = new Solution();
        String result = solution.solution(s);
        System.out.println("result: " + result);

    }

    public String solution(String s) {
        // 모두 소문자로 변경
        s = s.toLowerCase();

        StringBuffer result = new StringBuffer();
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            if (isFirst) {
                result.append(Character.toUpperCase(s.charAt(i)));
                isFirst = false;
            } else {
                result.append(s.charAt(i));
            }
            // 공백인 경우 boolean 변경
            if (s.charAt(i) == ' ') {
                isFirst = true;
            }
        }

        return result.toString();
    }
}
