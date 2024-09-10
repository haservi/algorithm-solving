package programmers.Level0.solution._87_접두사인지_확인하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181906?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "banana";
        String is_prefix = "ban";
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(my_string, is_prefix);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }

}
