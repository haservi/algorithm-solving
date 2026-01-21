package programmers.Level0.solution._192_옹알이_1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120956?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(babbling);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String bab : babbling) {
            String temp = bab;
            for (String word : words) {
                temp = temp.replace(word, " ");
            }
            if (temp.trim().isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
