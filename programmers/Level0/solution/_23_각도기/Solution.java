package programmers.Level0.solution._23_각도기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120829
 */
public class Solution {

    public static void main(String[] args) {
        int angle = 180;

        Solution solution = new Solution();
        int result = solution.solution(angle);
        System.out.println("result: " + result);
    }

    public int solution(int angle) {
        if (0 < angle && angle < 90) {
            return 1;
        }
        if (angle == 90) {
            return 2;
        }
        if (90 < angle && angle < 180) {
            return 3;
        }
        if (angle == 180) {
            return 4;
        }
        return 0;
    }
}
