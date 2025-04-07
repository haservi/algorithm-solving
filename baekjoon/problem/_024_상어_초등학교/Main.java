package baekjoon.problem._024_상어_초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21608
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            Map<Integer, Set<Integer>> likesMap = new HashMap<>();
            int[] studentOrder = new int[N * N];

            for (int i = 0; i < N * N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int studentId = Integer.parseInt(st.nextToken());
                studentOrder[i] = studentId;

                Set<Integer> likedSet = new HashSet<>();
                for (int j = 0; j < 4; j++) {
                    likedSet.add(Integer.valueOf(st.nextToken()));
                }
                likesMap.put(studentId, likedSet);
            }

            int result = solution(N, studentOrder, likesMap);
            System.out.println(result);

            br.close();

        }
    }

    // 인접 칸 이동 (상, 하, 좌, 우)
    private static final int[] dr = { -1, 1, 0, 0 };
    private static final int[] dc = { 0, 0, -1, 1 };
    // 만족도 점수 배열 (0, 1, 2, 3, 4명 인접 시 점수)
    private static final int[] satisfactionPoints = { 0, 1, 10, 100, 1000 };

    static class SeatCandidate implements Comparable<SeatCandidate> {
        int row;
        int column;
        int likedCount;
        int emptyCount;

        SeatCandidate(int r, int c, int liked, int empty) {
            this.row = r;
            this.column = c;
            this.likedCount = liked;
            this.emptyCount = empty;
        }

        // 자리 선정 우선순위 비교
        @Override
        public int compareTo(SeatCandidate other) {
            // 좋아하는 학생 많은 순
            if (this.likedCount != other.likedCount) {
                return other.likedCount - this.likedCount;
            }
            // 빈 칸 많은 순
            if (this.emptyCount != other.emptyCount) {
                return other.emptyCount - this.emptyCount;
            }
            // 행 번호 작은 순
            if (this.row != other.row) {
                return this.row - other.row;
            }
            // 열 번호 작은 순
            return this.column - other.column;
        }
    }

    public static int solution(int n, int[] studentOrder, Map<Integer, Set<Integer>> likesMap) {
        int[][] grid = new int[n][n]; // 교실 좌석 배치도

        // 학생 순서대로 자리 배치
        for (int studentId : studentOrder) {
            SeatCandidate bestSeat = null;

            // 모든 빈 칸을 탐색하여 최적의 자리 찾기
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 0) { // 빈 칸만 고려
                        int currentLikedCount = 0;
                        int currentEmptyCount = 0;

                        // 현재 빈 칸 (r, c)의 인접 칸 정보 계산
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];

                            // 격자 범위 내
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                if (grid[nr][nc] == 0) {
                                    // 인접한 빈 칸 수
                                    currentEmptyCount++;
                                } else if (likesMap.get(studentId).contains(grid[nr][nc])) {
                                    // 인접한 좋아하는 학생 수
                                    currentLikedCount++;
                                }
                            }
                        }

                        SeatCandidate currentCandidate = new SeatCandidate(r, c, currentLikedCount, currentEmptyCount);

                        // 더 좋은 자리인지 비교 후 갱신
                        if (bestSeat == null || currentCandidate.compareTo(bestSeat) < 0) {
                            bestSeat = currentCandidate;
                        }
                    }
                }
            }
            // 찾은 최적의 자리에 학생 배치
            grid[bestSeat.row][bestSeat.column] = studentId;
        }

        // 최종 만족도 계산
        int totalSatisfaction = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int currentStudent = grid[r][c];
                Set<Integer> likedSet = likesMap.get(currentStudent);
                int likedNeighbors = 0;

                // 인접 칸을 확인하여 좋아하는 학생 수 계산
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (likedSet.contains(grid[nr][nc])) {
                            likedNeighbors++;
                        }
                    }
                }
                // 현재 학생의 만족도 점수 누적
                totalSatisfaction += satisfactionPoints[likedNeighbors];
            }
        }

        return totalSatisfaction;
    }

}
