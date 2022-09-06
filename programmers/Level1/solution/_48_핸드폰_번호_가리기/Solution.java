package programmers.Level1.solution._48_핸드폰_번호_가리기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=java
 */
public class Solution {

    public static void main(String[] args) {

        String phoneNumber = "01033334444";

        Solution solution = new Solution();
        String result = solution.solution(phoneNumber);
        System.out.println("result: " + result);
    }

    public String solution(String phone_number) {

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            if (i < phone_number.length() - 4) {
                answer.append("*");
            } else {
                answer.append(phone_number.charAt(i));
            }
        }

        return answer.toString();
    }

}
