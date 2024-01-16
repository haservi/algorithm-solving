package programmers.Level0.solution._46_평행;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120875
 */
public class Solution {

    public static void main(String[] args) {
        int[][] dots = { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } };
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution2(dots);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 로직이 같은거 같은데 아래 함수로 하면 실패함
     */
    public int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);
                // 이전 기울기와 동일한 값이 존재하는 경우 기울기가 같은 경우가 있어서 평행
                if (slopes.contains(slope)) {
                    return 1;
                }
                slopes.add(slope);
            }
        }
        return 0;
    }

    /**
     * 단순하게 문제의 목적에 맞게 4개의 점을 각각 그려서 기울기가 같은 경우만 return 1
     */
    public int solution2(int[][] dots) {
        double line1 = getSlope(dots[0][0], dots[0][1], dots[1][0], dots[1][1]);
        double line6 = getSlope(dots[2][0], dots[2][1], dots[3][0], dots[3][1]);
        if (line1 == line6) {
            return 1;
        }

        double line2 = getSlope(dots[0][0], dots[0][1], dots[2][0], dots[2][1]);
        double line5 = getSlope(dots[1][0], dots[1][1], dots[3][0], dots[3][1]);
        if (line2 == line5) {
            return 1;
        }

        double line3 = getSlope(dots[0][0], dots[0][1], dots[3][0], dots[3][1]);
        double line4 = getSlope(dots[1][0], dots[1][1], dots[2][0], dots[2][1]);
        if (line3 == line4) {
            return 1;
        }

        return 0;
    }

    /**
     * 두 점을 잇는 직선의 기울기를 구하는 함수
     */
    private double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}
