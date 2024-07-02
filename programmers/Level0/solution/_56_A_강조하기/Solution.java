package programmers.Level0.solution._56_A_강조하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181874?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "abstract algebra";
        String expectedResult = "AbstrAct AlgebrA";

        Solution solution = new Solution();
        String result = solution.solution(myString);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String myString) {
        myString = myString.toLowerCase();

        StringBuilder answer = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (c == 'a') {
                answer.append('A');
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}
