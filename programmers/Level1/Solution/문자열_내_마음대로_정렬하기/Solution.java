package programmers.Level1.Solution.문자열_내_마음대로_정렬하기;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] strings = { "sun", "bed", "car" };
    int n = 1;
    String[] result = solution.solution(strings, n);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];
    int count = strings.length;

    Arrays.sort(strings);

    for (int i = 0; i < count; i++) {
      int min = i;
      for (int j = i + 1; j < count; j++) {
        if (strings[min].charAt(n) > strings[j].charAt(n)) {
          min = j;
        }
      }
      String key = strings[min];
      while (min > i) {
        strings[min] = strings[min - 1];
        min--;
      }

      answer[i] = key;
    }

    return answer;
  }

}
