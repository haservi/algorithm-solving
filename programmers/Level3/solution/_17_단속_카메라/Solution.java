package programmers.Level3.solution._17_단속_카메라;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(routes);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int answer = 0;
        int last = Integer.MIN_VALUE;
        for (int[] route : routes) {
            // 시작보다 크고 종료보다 작을 때는 무시
            if (route[0] <= last && last <= route[1]) {
                continue;
            }
            last = route[1];
            answer++;
        }

        return answer;
    }
}
