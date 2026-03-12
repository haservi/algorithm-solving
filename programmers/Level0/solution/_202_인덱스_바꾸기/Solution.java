package programmers.Level0.solution._202_인덱스_바꾸기;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120895?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String myString = "hello";
        int num1 = 1;
        int num2 = 2;
        String expectedResult = "hlelo";

        Solution solution = new Solution();
        String result = solution.solution(myString, num1, num2);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();

        char temp = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = temp;

        return new String(chars);
    }

}
