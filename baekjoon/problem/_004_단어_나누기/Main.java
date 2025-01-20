package baekjoon.problem._004_단어_나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1251
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = solution(br.readLine());
        System.out.println(result);
    }

    public static String solution(String alphabet) {
        int length = alphabet.length();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String part1 = new StringBuilder(alphabet.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(alphabet.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(alphabet.substring(j)).reverse().toString();
                pq.add(part1 + part2 + part3);
            }
        }

        return pq.poll();
    }
}
