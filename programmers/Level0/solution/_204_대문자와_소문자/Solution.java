package programmers.Level0.solution._204_대문자와_소문자;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120893?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "cccCCC";
        String expectedResult = "CCCccc";

        Solution solution = new Solution();
        String result = solution.solution(my_string);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for (char letter : my_string.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                answer.append(Character.toLowerCase(letter));
            } else {
                answer.append(Character.toUpperCase(letter));
            }
        }

        return answer.toString();
    }
}
