package programmers.Level1.solution._50_숫자_짝꿍;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */
public class Solution {

    public static void main(String[] args) {
        String X = "100";
        String Y = "203045";

        Solution solution = new Solution();
        String result = solution.solution(X, Y);
        System.out.println("result: " + result);
    }

    public String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int xCount = X.length() - X.replace(i + "", "").length();
            int yCount = Y.length() - Y.replace(i + "", "").length();
            if (xCount != 0 && yCount != 0) {
                int min = Math.min(xCount, yCount);
                for (int j = 0; j < min; j++) {
                    stringBuilder.append(i);
                }
            }
        }

        if (stringBuilder.length() == 0) {
            return "-1";
        }

        return stringBuilder.toString().replaceFirst("^0+(?!$)", "");
    }

}
