package programmers.Level0.solution._79_대문자로_바꾸기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181877?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "aBcDeFg";
        String expectedResult = "ABCDEFG";

        Solution solution = new Solution();
        String result = solution.solution(myString);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String myString) {
        return myString.toUpperCase();
    }
}
