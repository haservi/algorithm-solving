package programmers.Level0.solution._140_컨트롤_제트;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120853?language=java
 */
class Solution {

    public static void main(String[] args) {
        String s = "1 2 Z 3";
        int expectedResults = 4;

        Solution solution = new Solution();
        int result = solution.solution(s);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String s) {
        int answer = 0;
        String[] splits = s.split(" ");
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals("Z")) {
                answer -= Integer.parseInt(splits[i - 1]);
            } else {
                answer += Integer.parseInt(splits[i]);
            }
        }
        return answer;
    }
}
