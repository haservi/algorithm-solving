package programmers.Level1.음양_더하기;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] absolutes = { 1, 2, 3 };
        boolean[] signs = { true, false, true };

        int result = solution.solution(absolutes, signs);
        System.out.println("결과값 : " + result);
    }

    private int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int count = absolutes.length;
        for (int i = 0; i < count; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}