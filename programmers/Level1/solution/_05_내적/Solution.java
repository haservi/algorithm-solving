package programmers.Level1.solution._05_내적;

/**
 * 1. a와 b의 배열의 길이가 같기 때문에 해당 길이 만큼 각각의 배열의 값을 곱한 후 더하면 된다.
 */
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
