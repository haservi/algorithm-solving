package programmers.Level2.solution._65_방문_길이;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        int expectedResult = 7;

        Solution solution = new Solution();
        int result = solution.solution(dirs);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String dirs) {
        Set<String> visitedPaths = new HashSet<>();

        int startX = 5;
        int startY = 5;
        int answer = 0;

        for (char direction : dirs.toCharArray()) {
            int nextX = startX;
            int nextY = startY;

            // 방향에 따라 좌표를 변경
            switch (direction) {
                case 'U' -> nextY++;
                case 'D' -> nextY--;
                case 'R' -> nextX++;
                case 'L' -> nextX--;
            }

            // 유효한 범위 내에서만 이동
            if (nextX >= 0 && nextX <= 10 && nextY >= 0 && nextY <= 10) {
                String path1 = startX + "" + startY + "" + nextX + "" + nextY;
                String path2 = nextX + "" + nextY + "" + startX + "" + startY;

                // 경로가 처음 방문한 경우에만 정답을 증가
                if (visitedPaths.add(path1) && visitedPaths.add(path2)) {
                    answer++;
                }

                startX = nextX;
                startY = nextY;
            }
        }

        return answer;
    }

}
