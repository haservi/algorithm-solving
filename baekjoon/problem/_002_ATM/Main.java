package baekjoon.problem._002_ATM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11399
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer sk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sk.nextToken());
        }

        int result = solution(arr);
        System.out.println(result);
    }

    public static int solution(int[] users) throws Exception {
        int waitTime = 0;
        int totalWaitTime = 0;
        // 값을 오름차순으로 정렬
        Arrays.sort(users);

        for (int wait : users) {
            waitTime += wait;
            totalWaitTime += waitTime;
        }
        return totalWaitTime;
    }

}
