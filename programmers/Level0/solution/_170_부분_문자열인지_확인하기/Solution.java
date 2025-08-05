package programmers.Level0.solution._170_부분_문자열인지_확인하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181843?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "banana";
        String target = "ana";
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(my_string, target);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String my_string, String target) {
        return my_string.contains(target) ? 1 : 0;
    }
}
