package programmers.Level3.solution._10_여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43164
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] tickets = {
                { "ICN", "SFO" },
                { "ICN", "ATL" },
                { "SFO", "ATL" },
                { "ATL", "ICN" },
                { "ATL", "SFO" }
        };
        String[] result = solution.solution(tickets);
        System.out.println("result: " + Arrays.toString(result));
    }

    private static String START_POINT_ICN = "ICN";
    private static boolean[] visited;
    private static List<String> routeList = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        // 항공편의 경유 수 만큼 방문 값 추가
        visited = new boolean[tickets.length];

        int count = 0;

        // 무조건 출발은 인천 공항
        dfs(START_POINT_ICN, START_POINT_ICN, tickets, count);
        Collections.sort(routeList);

        return routeList.get(0).split(" ");
    }

    public static void dfs(String start, String dest, String[][] tickets, int count) {
        // 모든 티켓을 사용한 경유지 저장 후 return
        if (count == tickets.length) {
            routeList.add(dest);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], dest + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}