package programmers.Level0.solution._35_삼각형의_완성조건_1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120889
 */
public class Solution {

    public static void main(String[] args) {
        int[] sides = { 1, 2, 3 };

        Solution solution = new Solution();
        int result = solution.solution(sides);
        System.out.println("result: " + result);
    }

    public int solution(int[] sides) {
        int max = 0;
        int sum = 0;
        for (int side : sides) {
            if (max < side) {
                max = side;
            }
            sum += side;
        }
        sum -= max;
        if (sum <= max) {
            return 2;
        } else {
            return 1;
        }
    }

}
