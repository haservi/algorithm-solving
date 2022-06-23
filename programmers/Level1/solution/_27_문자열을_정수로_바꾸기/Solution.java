package programmers.Level1.solution._27_문자열을_정수로_바꾸기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12925
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "2133";

        int result = solution.solution(s);
        System.out.println("결과 : " + result);
    }

    public int solution(String s) {
        boolean negative = false;
        int i = 0;
        int len = s.length();

        char firstChar = s.charAt(0);
        if (firstChar < '0') {
            if (firstChar == '-') {
                negative = true;
            }
            i++;
        }
        int result = 0;
        while (i < len) {
            int digit = Character.digit(s.charAt(i++), 10);
            result *= 10;
            result -= digit;
        }
        return negative ? result : -result;
    }
}
