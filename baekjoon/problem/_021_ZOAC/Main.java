package baekjoon.problem._021_ZOAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/16719
 */

public class Main {
    static char[] str;
    static boolean[] vis;
    static int len;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            str = input.toCharArray();
            len = str.length;
            vis = new boolean[len];

            zoac(0, len);

            System.out.print(result);
        }
    }

    // start와 end 범위 내에서 방문하지 않은 가장 작은 문자의 인덱스를 찾는 함수
    private static int findMinIndex(int start, int end) {
        int minIdx = -1;
        // char 타입 최대값 사용 가능
        char minChar = Character.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (!vis[i] && str[i] < minChar) {
                minChar = str[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static void zoac(int start, int end) {
        // 현재 범위에서 가장 작은 문자 인덱스 찾기
        int idx = findMinIndex(start, end);

        // 찾았으면 처리 (방문 표시, 출력, 재귀 호출)
        if (idx != -1) {
            vis[idx] = true;

            // 현재 상태 출력 문자열 생성
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (vis[i]) {
                    current.append(str[i]);
                }
            }
            result.append(current).append('\n');

            // 재귀 호출 (오른쪽 먼저, 다음 왼쪽)
            zoac(idx + 1, end);
            zoac(start, idx);
        }
    }
}
