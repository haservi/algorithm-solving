package baekjoon.problem._007_수리공_항승;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1449
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = solution(L, arr);
        System.out.println(result);
    }

    public static int solution(int tape, int[] leaks) {
        // 물이 새는 곳을 정렬
        Arrays.sort(leaks);

        int count = 0;
        // 현재 테이프가 커버하는 끝 위치
        float currentEnd = 0;

        for (int leak : leaks) {
            // 현재 테이프가 커버하지 못하는 위치라면 새 테이프 사용
            if (leak > currentEnd) {
                count++;
                // 테이프의 새로운 끝 범위 설정
                currentEnd = leak - 0.5f + tape;
            }
        }

        return count;
    }

}
