package programmers.Level0.solution._189_l로_만들기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181834?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "abcdevwxyz";
        String expectedResult = "lllllvwxyz";

        Solution solution = new Solution();
        String result = solution.solution(myString);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (c < 'l') {
                answer.append('l');
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}
