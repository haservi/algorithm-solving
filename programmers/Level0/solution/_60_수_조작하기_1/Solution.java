package programmers.Level0.solution._60_수_조작하기_1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181926?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 0;
        String control = "wsdawsdassw";
        int expectedResult = -1;

        Solution solution = new Solution();
        int result = solution.solution(n, control);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n, String control) {
        int answer = n;
        for (char c : control.toCharArray()) {
            switch (c) {
                case 'w' -> answer += 1;
                case 's' -> answer -= 1;
                case 'd' -> answer += 10;
                case 'a' -> answer -= 10;
            }
        }
        return answer;
    }
}
