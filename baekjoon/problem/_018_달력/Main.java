package baekjoon.problem._018_달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20207
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int[][] schedules = new int[count][2];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(schedules);
        System.out.println(result);
    }


    private static int solution(int[][] schedules) {
        Arrays.sort(schedules, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] calendar = new int[366]; 
        for (int[] schedule : schedules) {
            for (int day = schedule[0]; day <= schedule[1]; day++) {
                calendar[day]++;
            }
        }

        int width = 0;
        int height = 0;
        int area = 0;
        for (int day = 1; day <= 365; day++) {
            if (calendar[day] > 0) {
                width++;
                height = Math.max(height, calendar[day]);
            } else {
                area += width * height;
                width = 0;
                height = 0;
            }
        }
        // 마지막 남은 영역 추가
        area += width * height; 

        return area;
    }

}
