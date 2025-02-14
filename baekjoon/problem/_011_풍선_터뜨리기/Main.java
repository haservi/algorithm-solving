package baekjoon.problem._011_풍선_터뜨리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/2346
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] papers = new int[N];
        for (int i = 0; i < N; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(papers);
        System.out.print(result);
    }

    static class Balloon {
        int index;
        int paper;

        Balloon(int index, int paper) {
            this.index = index;
            this.paper = paper;
        }
    }

    private static String solution(int[] papers) {
        StringBuilder sb = new StringBuilder();

        LinkedList<Balloon> balloons = new LinkedList<>();
        for (int i = 0; i < papers.length; i++) {
            balloons.add(new Balloon(i + 1, papers[i]));
        }

        int index = 0;
        while (!balloons.isEmpty()) {
            Balloon current = balloons.remove(index);
            sb.append(current.index).append(" ");
            if (balloons.isEmpty())
                break;

            int steps = current.paper;
            if (steps > 0) {
                index = (index + steps - 1) % balloons.size();
            } else {
                index = (index + steps) % balloons.size();
                if (index < 0) {
                    index += balloons.size();
                }
            }
        }

        return sb.toString();
    }

}
