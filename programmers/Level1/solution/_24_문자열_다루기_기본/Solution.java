package programmers.Level1.solution._24_문자열_다루기_기본;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 * 1. 정규식을 이용하여 해결한다.
 * 2. 길이가 4, 6인 정수만 검색하는 정규식 구현
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "132234";

        boolean result = solution.solution(s);
        System.out.println("결과 : " + result);
    }

    public boolean solution(String s) {
        boolean answer = true;
        String regex = "^[0-9]{4}$|^[0-9]{6}$";
        if (s.matches(regex)) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}
