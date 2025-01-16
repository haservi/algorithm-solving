package baekjoon.problem._001_대표_자연수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2548
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

    public static int solution(int[] numbers) throws Exception {
        Arrays.sort(numbers);
        if (numbers.length % 2 == 0) {
            return numbers[numbers.length / 2 - 1];
        } else {
            return numbers[numbers.length / 2];
        }
    }

}
