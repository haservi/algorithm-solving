package programmers.Level2.solution._31_거리두기_확인하기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[][] places = {
                { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
                { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" }
        };
        int[] expected = { 1, 0, 1, 1, 1 };

        Solution solution = new Solution();
        int[] result = solution.solution(places);
        if (Arrays.equals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = isSafeDistance(places[i]) ? 1 : 0;
        }
        return answer;
    }

    private boolean isSafeDistance(String[] place) {
        char[][] room = new char[place.length][];
        for (int j = 0; j < room.length; j++) {
            room[j] = place[j].toCharArray();
        }

        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] == 'P' && !isDistanced(room, x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static final int[] DIRECTIONS_X = { 0, -1, 1, 0 };
    private static final int[] DIRECTIONS_Y = { -1, 0, 0, 1 };

    private boolean isDistanced(char[][] room, int x, int y) {
        // 상하좌우 조회
        for (int d = 0; d < 4; d++) {
            int nx = x + DIRECTIONS_X[d];
            int ny = y + DIRECTIONS_Y[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }
            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    // 공간이 있는 경우 다음 방을 조회(3 - d는 반대 방향 즉 자신의 방은 제외)
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) {
                continue;
            }
            int nx = x + DIRECTIONS_X[d];
            int ny = y + DIRECTIONS_Y[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }
            if (room[ny][nx] == 'P') {
                return true;
            }
        }
        return false;
    }

}
