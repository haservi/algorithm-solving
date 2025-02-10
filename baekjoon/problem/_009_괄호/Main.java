package baekjoon.problem._009_괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(solution(br.readLine())).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static String solution(String input) {
        int balance = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    return "NO";
                }
            }
        }

        return balance == 0 ? "YES" : "NO";
    }
}
