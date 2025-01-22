package baekjoon.problem._006_두_용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2470
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        String result = solution(arr);
        System.out.println(result);
    }

    public static String solution(long[] liquids) {
        Arrays.sort(liquids);

        int left = 0;
        int right = liquids.length - 1;
        long min = Long.MAX_VALUE;
        long number1 = 0;
        long number2 = 0;

        while (left < right) {
            long sum = liquids[left] + liquids[right];

            // 절대값이 더 작은 경우 갱신
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                number1 = liquids[left];
                number2 = liquids[right];
            }

            // 합이 0에 가까워지는 방향으로 포인터 이동
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        // 작은 값을 먼저 반환
        if (number1 > number2) {
            long temp = number1;
            number1 = number2;
            number2 = temp;
        }

        return number1 + " " + number2;
    }

}
