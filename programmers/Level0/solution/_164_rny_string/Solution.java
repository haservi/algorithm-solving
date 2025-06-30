package programmers.Level0.solution._164_rny_string;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181863?language=java
 */
class Solution {

    public static void main(String[] args) {
        String rny_string = "masterpiece";
        String expectedResult = "rnasterpiece";

        Solution solution = new Solution();
        String result = solution.solution(rny_string);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String rny_string) {
        return rny_string.replaceAll("m", "rn");
    }
}
