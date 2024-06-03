package programmers.pccp.solution._01_외톨이_알파벳;

public class Solution {

    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        String expectedResult = "de";

        Solution solution = new Solution();
        String result = solution.solution(input_string);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String input_string) {
        input_string = "." + input_string + ".";

        StringBuilder builder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (input_string.split(c + "+").length < 3) {
                continue;
            }
            builder.append(c);
        }

        if (builder.length() == 0) {
            return "N";
        }
        return builder.toString();
    }
}
