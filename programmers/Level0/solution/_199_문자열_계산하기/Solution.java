package programmers.Level0.solution._199_문자열_계산하기;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120902?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String myString = "3 + 4";
        int expectedResult = 7;

        Solution solution = new Solution();
        int result = solution.solution(myString);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String my_string) {
        String[] parts = my_string.split(" ");
        int answer = Integer.parseInt(parts[0]);

        for (int i = 1; i < parts.length; i += 2) {
            String operator = parts[i];
            int num = Integer.parseInt(parts[i + 1]);

            if (operator.equals("+")) {
                answer += num;
            } else {
                answer -= num;
            }
        }

        return answer;
    }

}
