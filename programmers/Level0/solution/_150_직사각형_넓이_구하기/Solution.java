package programmers.Level0.solution._150_직사각형_넓이_구하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120860?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] dots = { { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };
        int expectedResults = 4;

        Solution solution = new Solution();
        int result = solution.solution(dots);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] dots) {
        if (dots == null || dots.length == 0) {
            return 0;
        }

        // 초기값 설정
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        // 모든 점을 확인하며 최소/최대 x,y 좌표 찾기
        for (int[] dot : dots) {
            minX = Math.min(minX, dot[0]);
            maxX = Math.max(maxX, dot[0]);
            minY = Math.min(minY, dot[1]);
            maxY = Math.max(maxY, dot[1]);
        }

        // 사각형의 넓이 계산
        int width = maxX - minX;
        int height = maxY - minY;

        return width * height;
    }

}
