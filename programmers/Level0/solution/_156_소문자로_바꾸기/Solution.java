package programmers.Level0.solution._156_소문자로_바꾸기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181876?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "aBcDeFg";
        String expectedResult = "abcdefg";

        Solution solution = new Solution();
        String result = solution.solution(myString);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String myString) {
        return myString.toLowerCase();
    }
}
