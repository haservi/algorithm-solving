package programmers.Level2.solution._28_교점에_별_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };
        String[] expected = {
                "....*....",
                ".........",
                ".........",
                "*.......*",
                ".........",
                ".........",
                ".........",
                ".........",
                "*.......*"
        };

        Solution solution = new Solution();
        String[] result = solution.solution(line);

        if (Arrays.equals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                Point intersecetion = calculateIntersection(line[i], line[j]);

                if (intersecetion != null) {
                    points.add(intersecetion);
                }
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        // 최대 넓이 사각형에 '.' 추가
        char[][] map = new char[height][width];
        for (char[] row : map) {
            Arrays.fill(row, '.');
        }

        // 별 찍기
        for (Point point : points) {
            int x = (int) (point.x - minimum.x);
            int y = (int) (maximum.y - point.y);
            map[y][x] = '*';
        }

        String[] result = new String[map.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(map[i]);
        }

        return result;
    }

    private static class Point {

        private final long x;
        private final long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 문제에서 제공하는 공식
     * 
     * @param line1
     * @param line2
     * @return
     */
    private Point calculateIntersection(int[] line1, int[] line2) {
        long A = line1[0];
        long B = line1[1];
        long E = line1[2];
        long C = line2[0];
        long D = line2[1];
        long F = line2[2];

        double x = (B * F - D * E) / (double) (A * D - C * B);
        double y = (C * E - A * F) / (double) (A * D - C * B);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    /**
     * 가장 작은 좌표 값
     * 
     * @param points 좌표 리스트
     * @return
     */
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }
        return new Point(x, y);
    }

    /**
     * 가장 큰 좌표 값
     * 
     * @param points 좌표 리스트
     * @return
     */
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }
        return new Point(x, y);
    }
}
