package programmers.Level0.solution._97_다항식_더하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120863?language=java
 */
class Solution {

    public static void main(String[] args) {
        String polynomial = "3x + 7 + x";
        String expectedResult = "4x + 7";

        Solution solution = new Solution();
        String result = solution.solution(polynomial);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String polynomial) {
        String[] arr = polynomial.replace(" ", "").split("\\+");

        int xNumber = 0;
        int number = 0;

        for (String term : arr) {
            if (term.contains("x")) {
                xNumber += term.equals("x") ? 1 : Integer.parseInt(term.replace("x", ""));
            } else {
                number += Integer.parseInt(term);
            }
        }

        StringBuilder result = new StringBuilder();
        if (xNumber != 0) {
            result.append(xNumber == 1 ? "x" : xNumber + "x");
        }
        if (number != 0) {
            if (xNumber != 0) {
                result.append(" + ");
            }
            result.append(number);
        }

        return result.toString();
    }
}
