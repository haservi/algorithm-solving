package programmers.Level0.solution._109_qr_code;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181903?language=java
 */
class Solution {

    public static void main(String[] args) {
        int q = 3;
        int r = 1;
        String code = "qjnwezgrpirldywt";
        String expectedResult = "jerry";

        Solution solution = new Solution();
        String result = solution.solution(q, r, code);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                answer.append(code.charAt(i));
            }
        }
        return answer.toString();
    }

}
