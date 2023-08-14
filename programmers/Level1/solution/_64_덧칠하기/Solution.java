package programmers.Level1.solution._64_덧칠하기;

public class Solution {

    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int[] section = { 1, 3 };
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(n, m, section);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int draw = section[0];
        for (int i : section) {
            if ((draw + m - 1) < i) {
                draw = i;
                answer++;
            }
        }
        return answer;
    }
}
