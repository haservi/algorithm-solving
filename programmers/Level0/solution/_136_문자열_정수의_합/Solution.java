package programmers.Level0.solution._136_문자열_정수의_합;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181849?language=java
 */
class Solution {

    public static void main(String[] args) {
        String num_str = "123456789";
        int expectedResults = 45;

        Solution solution = new Solution();
        int result = solution.solution(num_str);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String num_str) {
        int answer = 0;
        for (int i = 0; i < num_str.length(); i++) {
            answer += Integer.parseInt(String.valueOf(num_str.charAt(i)));
        }
        return answer;
    }

    public int solution2(String num_str) {
        return num_str.chars().map(Character::getNumericValue).sum();
    }

}
