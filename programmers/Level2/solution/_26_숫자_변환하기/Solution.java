package programmers.Level2.solution._26_숫자_변환하기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;
        int expected = 2;

        Solution solution = new Solution();
        int result = solution.solution(x, y, n);

        if (expected == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == -1) {
                continue;
            }

            int doubleJump = i * 2;
            int tripleJump = i * 3;
            int addN = i + n;

            if (doubleJump <= y) {
                if (dp[doubleJump] == -1) {
                    dp[doubleJump] = dp[i] + 1;
                } else {
                    dp[doubleJump] = Math.min(dp[doubleJump], dp[i] + 1);
                }
            }
            if (tripleJump <= y) {
                if (dp[tripleJump] == -1) {
                    dp[tripleJump] = dp[i] + 1;
                } else {
                    dp[tripleJump] = Math.min(dp[tripleJump], dp[i] + 1);
                }
            }
            if (addN <= y) {
                if (dp[addN] == -1) {
                    dp[addN] = dp[i] + 1;
                } else {
                    dp[addN] = Math.min(dp[addN], dp[i] + 1);
                }
            }
        }

        return dp[y];
    }
}
