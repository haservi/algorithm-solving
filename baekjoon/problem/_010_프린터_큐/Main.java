package baekjoon.problem._010_프린터_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tastCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < tastCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] results = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                results[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(solution(N, M, results)).append('\n');
        }

        System.out.print(sb.toString());
    }

    static class PrintQueue {
        int index;
        int priority;

        PrintQueue(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static int solution(int N, int M, int[] results) {
        Queue<PrintQueue> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new PrintQueue(i, results[i]));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            PrintQueue front = queue.poll();
            boolean isMax = true;

            for (PrintQueue next : queue) {
                // 뽑은 원소보다 큰 원소가 있는 경우
                if (front.priority < next.priority) {
                    // 뽑은 원소를 뒤로 보냄
                    queue.offer(front);
                    isMax = false;
                    break;
                }
            }

            if (!isMax) {
                continue;
            }

            count++;
            if (front.index == M) {
                break;
            }
        }

        return count;
    }
}
