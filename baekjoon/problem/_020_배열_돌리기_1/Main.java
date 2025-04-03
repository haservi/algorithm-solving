package baekjoon.problem._020_배열_돌리기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16926
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dimensions = new int[3];
        for (int i = 0; i < 3; i++) {
            dimensions[i] = Integer.parseInt(st.nextToken());
        }

        int height = dimensions[0];
        int width = dimensions[1];
        int rotate = dimensions[2];

        int[][] arr = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr, height, width, rotate);
        printMatrix(arr);
    }

    private static void solution(int[][] arr, int height, int width, int rotate) {
        int count = Math.min(height, width) / 2;

        for (int i = 0; i < rotate; i++) {
            // 각 레벨의 원소 회전
            for (int j = 0; j < count; j++) {
                int temp = arr[j][j];

                // 1. 위쪽 라인 회전
                for (int k = j + 1; k < width - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }

                // 2. 오른쪽 라인 회전
                for (int k = j + 1; k < height - j; k++) {
                    arr[k - 1][width - 1 - j] = arr[k][width - 1 - j];
                }

                // 3. 아래쪽 라인 회전
                for (int k = width - 2 - j; k >= j; k--) {
                    arr[height - 1 - j][k + 1] = arr[height - 1 - j][k];
                }

                // 4. 왼쪽 라인 회전
                for (int k = height - 2 - j; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }

                // 저장했던 첫 번째 원소를 마지막 위치에 삽입
                arr[j + 1][j] = temp;
            }
        }
    }

    private static void printMatrix(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
