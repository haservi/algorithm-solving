package programmers.Level0.solution._148_숨어있는_숫자의_덧셈_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120864?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "aAb1B2cC34oOp";
        int expectedResults = 37;

        Solution solution = new Solution();
        int result = solution.solution(my_string);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String my_string) {
        String stringNumber = "";
        int answer = 0;
        for (char c : my_string.toCharArray()) {

            if (48 < c && c < 57) {
                stringNumber += c;
            } else {
                if (!stringNumber.equals("")) {
                    answer += Integer.parseInt(stringNumber);
                    stringNumber = "";
                }
            }
        }
        return answer;
    }

    public int solution2(String my_string) {
        StringBuilder stringNumber = new StringBuilder();
        int answer = 0;

        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                stringNumber.append(c);
            } else {
                if (stringNumber.length() > 0) {
                    answer += Integer.parseInt(stringNumber.toString());
                    stringNumber.setLength(0);
                }
            }
        }

        if (stringNumber.length() > 0) {
            answer += Integer.parseInt(stringNumber.toString());
        }

        return answer;
    }
}
