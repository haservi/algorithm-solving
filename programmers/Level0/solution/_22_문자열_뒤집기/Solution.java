package programmers.Level0.solution._22_문자열_뒤집기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120822
 */
public class Solution {

    public static void main(String[] args) {
        String my_string = "jaron";

        Solution solution = new Solution();
        String result = solution.solution(my_string);
        System.out.println("result: " + result);
    }

    public String solution(String my_string) {
        return new StringBuilder(my_string).reverse().toString();
    }

    
}
