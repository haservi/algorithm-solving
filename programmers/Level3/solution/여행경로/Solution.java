package programmers.Level3.solution.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    
    // String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
    String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    String[] result = solution.solution(tickets);
    System.out.println("result : " + Arrays.toString(result));
  }

  private static boolean[] visited;
  private static List<String> routeList;
  private static String[] tempAnswer;
  
  public String[] solution(String[][] tickets) {

    // Comparator<String[]> comparator = new Comparator<String[]>() {
    //   @Override
    //   public int compare(String[] o1, String[] o2) {
    //       return o1[1].compareTo(o2[1]);
    //   }
    // };
    
    // tickets 정렬(2번째 값으로 정렬)
    // Arrays.sort(tickets, comparator);
    Arrays.sort(tickets, Comparator.comparing(item -> item[1]));
    // for (String[] strings : tickets) {
    //   System.out.println(Arrays.toString(strings));
    // }

    // 항공편의 경유 수 만큼 방문 값 추가
    visited = new boolean[tickets.length];
    routeList = new ArrayList<>();
    // 가장 처음은 무조건 인천공항
    routeList.add("ICN");

    int count = 0;
    

    // 무조건 출발은 인천 공함
    dfs("ICN", tickets, count);

    System.out.println(routeList.toString());
    // String[] answer = routeList.toArray(new String[0]);
    String[] answer = tempAnswer;
    return answer;
  }

  private void dfs(String route, String[][] tickets, int count) {
    // 모든 티켓을 사용한 경우 return
    if (count == tickets.length) {
      // tempAnswer = routeList.toArray(new String[0]);
      tempAnswer = routeList.toArray(new String[0]);
      return;
    }

    for (int i = 0; i < tickets.length; i++) {
      if (!visited[i] && tickets[i][0].equals(route)) {
        visited[i] = true;
        routeList.add(tickets[i][1]);
        dfs(tickets[i][1], tickets, count + 1);

        // 다른 경우 확인
        // visited[i] = false;
        // routeList.remove(routeList.size() - 1);
      }
    }

  }





























  // public String[] solution(String[][] tickets) {
  //   visited = new boolean[tickets.length]; // 방문 확인용
  //   answerList = new ArrayList<>(); // 정답을 담을 리스트
  //   Arrays.sort(tickets, Comparator.comparing(t -> t[1]));
  //   dfs(0, "ICN", "ICN", tickets);

  //   return answerList.get(0).split(" ");
  // }

  // public static void dfs(int count, String start, String dest, String[][] tickets) {
  //   if (count == tickets.length) { // 모든공항 다돌았을때
  //     answerList.add(dest);
  //     return;
  //   }
  //   for (int i = 0; i < tickets.length; i++) {
  //     if (!visited[i] && tickets[i][0].equals(start)) {
  //       visited[i] = true;
  //       dfs(count + 1, tickets[i][1], dest + " " + tickets[i][1], tickets);
  //       visited[i] = false;
  //     }
  //   }
  // }

  
}