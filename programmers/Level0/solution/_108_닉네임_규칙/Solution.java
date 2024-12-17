package programmers.Level0.solution._108_닉네임_규칙;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340200?language=java
 */
class Solution {

    public static void main(String[] args) {
        String nickname = "WORLDworld";
        String expectedResult = "VV0RLDvv";

        Solution solution = new Solution();
        String result = solution.solution(nickname);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String nickname) {
        String answer = "";
        for (int i = 0; i < nickname.length(); i++) {
            if (nickname.charAt(i) == 'l') {
                answer += "I";
            } else if (nickname.charAt(i) == 'w') {
                answer += "vv";
            } else if (nickname.charAt(i) == 'W') {
                answer += "VV";
            } else if (nickname.charAt(i) == 'O') {
                answer += "0";
            } else {
                answer += nickname.charAt(i);
            }
        }
        for (int i = answer.length(); i < 4; i++) {
            answer += "o";
        }
        if (answer.length() > 8) {
            answer = answer.substring(0, 8);
        }
        return answer;
    }

}
