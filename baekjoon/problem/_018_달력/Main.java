package baekjoon.problem._018_달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int[] calendar = new int[366];
        // 캘린더에 일정 추가
        for (int[] schedule : schedules) {
            for (int day = schedule[0]; day <= schedule[1]; day++) {
                calendar[day]++;
            }
        }

        int width = 0;
        int height = 0;
        int area = 0;
        for (int day = 1; day <= calendar.length - 1; day++) {
            if (calendar[day] > 0) {
                // 일정이 이어지는 경우 가로 길이를 늘리고 해당 일정이 누적된 경우 height를 max로 설정
                width++;
                height = Math.max(height, calendar[day]);
            } else {
                area += (width * height);
                width = 0;
                height = 0;
            }
        }
        // 마지막 남은 영역 추가
        area += width * height;

        return area;
    }

}
