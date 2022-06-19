package programmers.Level1.solution.내적;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = { 1, 2, 3, 4 };
        int[] b = { -3, -1, 0, 2 };

        int result = solution.solution(a, b);

        System.out.println("result: " + result);
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        int size = a.length;
        for (int i = 0; i < size; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
