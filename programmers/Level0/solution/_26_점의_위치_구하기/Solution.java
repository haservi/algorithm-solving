package programmers.Level0.solution._26_점의_위치_구하기;

public class Solution {

    public static void main(String[] args) {
        int[] dot = { 2, 4 };

        Solution solution = new Solution();
        int result = solution.solution(dot);
        System.out.println("result: " + result);
    }

    public int solution(int[] dot) {
        if (0 < dot[0] && 0 < dot[1])
            return 1;
        if (dot[0] < 0 && 0 < dot[1])
            return 2;
        if (dot[0] < 0 && dot[1] < 0)
            return 3;
        if (0 < dot[0] && dot[1] < 0)
            return 4;
        return 0;
    }
}
