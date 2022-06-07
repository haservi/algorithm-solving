package programmers.Level3.Solution.베스트앨범;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] genres = { "classic", "pop", "classic", "classic", "pop" };
    int[] plays = { 500, 600, 150, 800, 2500 };

    int[] result = solution.solution(genres, plays);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> map = new HashMap<>();
    List<Integer> answer = new ArrayList<>();

    // 장르별 재생수 회수의 합
    for (int i = 0; i < genres.length; i++) {
      map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
    }
    // System.out.println("전체 재생 회수: " + map);

    List<String> list = new ArrayList<>(map.keySet());
    // System.out.println("리스트 정렬 전:" + list);
    list.sort((value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
    // System.out.println("리스트 정렬 후:" + list);

    for (String genre  : list) {
      int firstMaxIndex = 0;
      int secondMaxIndex = 0;
      int max = 0;

      for (int i = 0; i < genres.length; i++) {
        if (genre.equals(genres[i])) {
          if (plays[i] > max) {
            max = plays[i];
            firstMaxIndex = i;
          }
        }
      }
      max = 0;

      for (int i = 0; i < genres.length; i++) {
        if (genre.equals(genres[i])) {
          if (firstMaxIndex != i && plays[i] > max) {
            max = plays[i];
            secondMaxIndex = i;
          }
        }
      }

      answer.add(firstMaxIndex);
      if (max != 0) {
        answer.add(secondMaxIndex);
      }
    }

    // System.out.println(answer);
    
    return answer.stream().mapToInt(i -> i).toArray();
  }
}