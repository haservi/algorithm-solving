package baekjoon.problem._005_회의실_배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int result = solution(arr);
        System.out.println(result);
    }

    public static int solution(int[][] times) throws Exception {
        // 종료시간이 같을 경우 시작시간이 빠른 순서로 정렬
        Arrays.sort(times, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int count = 1;
        int endTime = times[0][1];
        for (int i = 0; i < times.length - 1; i++) {
            // 종료시간보다 다음 시작시간이 큰 경우 카운트 증가
            if (endTime <= times[i + 1][0]) {
                count++;
                endTime = times[i + 1][1];
            }
        }
        return count;
    }
}
