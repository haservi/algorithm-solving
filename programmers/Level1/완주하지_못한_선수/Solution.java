package programmers.Level1.완주하지_못한_선수;

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    
    String result = solution.solution(participant, completion);
    System.out.println("완주하지 못한 선수: " + result);
  }

  public String solution(String[] participant, String[] completion) {
    Arrays.sort(participant);
    Arrays.sort(completion);
    int i;
    for (i = 0; i < completion.length; i++) {
      if (!participant[i].equals(completion[i])) {
        return participant[i];
      }
    }
    return participant[i];
  }
}