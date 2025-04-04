package baekjoon.problem._022_빙고;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2578
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st;
            // 빙고판 저장 배열
            int[][] board = new int[5][5];
            // 사회자가 부르는 숫자 저장 배열
            int[][] calledNumbers = new int[5][5];

            // 빙고판 입력 받기
            for (int r = 0; r < 5; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 5; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 사회자가 부르는 숫자 입력 받기
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    calledNumbers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = solution(board, calledNumbers);
            System.out.println(result);
        }
    }

    // 숫자의 위치 (행, 열)을 저장하는 내부 클래스
    private static class Point {
        int row, column;

        Point(int r, int c) {
            this.row = r;
            this.column = c;
        }
    }

    public static int solution(int[][] board, int[][] calledNumbers) {
        // 각 숫자가 빙고판의 어디에 있는지 빠르게 찾기 위한 배열 (숫자 1~25 사용)
        Point[] positions = new Point[26];
        // 사회자가 부른 숫자를 표시할 배열
        boolean[][] marked = new boolean[5][5];

        // 빙고판을 읽고 각 숫자의 위치(Point)를 positions 배열에 저장
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                positions[board[r][c]] = new Point(r, c);
            }
        }

        // 사회자가 부르는 숫자를 순서대로 처리
        int callCount = 0; // 사회자가 부른 횟수
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                callCount++;
                int calledNum = calledNumbers[i][j];

                // 불린 숫자의 위치를 찾아 marked 배열에 표시
                Point pos = positions[calledNum];
                marked[pos.row][pos.column] = true;

                // 최소 5개 이상 불렸을 때부터 빙고 여부 확인
                if (callCount >= 5) {
                    // 현재 빙고 라인 수 확인
                    int currentBingos = checkBingo(marked);
                    if (currentBingos >= 3) {
                        // 3 빙고 달성 시점의 횟수 반환
                        return callCount;
                    }
                }
            }
        }
        return -1;
    }

    private static int checkBingo(boolean[][] marked) {
        int bingoLines = 0;

        // 가로(행) 빙고 확인
        for (int r = 0; r < 5; r++) {
            boolean rowComplete = true;
            for (int c = 0; c < 5; c++) {
                if (!marked[r][c]) {
                    rowComplete = false;
                    break;
                }
            }
            if (rowComplete)
                bingoLines++;
        }

        // 세로(열) 빙고 확인
        for (int c = 0; c < 5; c++) {
            boolean colComplete = true;
            for (int r = 0; r < 5; r++) {
                if (!marked[r][c]) {
                    colComplete = false;
                    break;
                }
            }
            if (colComplete)
                bingoLines++;
        }

        // 대각선 (\) 빙고 확인
        boolean diag1Complete = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                diag1Complete = false;
                break;
            }
        }
        if (diag1Complete)
            bingoLines++;

        // 대각선 (/) 빙고 확인
        boolean diag2Complete = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                diag2Complete = false;
                break;
            }
        }
        if (diag2Complete)
            bingoLines++;

        return bingoLines;
    }
}
