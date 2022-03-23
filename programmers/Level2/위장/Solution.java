package programmers.Level2.위장;

import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[][] clothes = { 
      { "yellowhat", "headgear" },
      { "yellowhat1", "headgear" },
      { "bluesunglasses", "eyewear" },
      { "bluesunglasses1", "eyewear" },
      { "green_turban", "face" },
      { "green_turban1", "face" }
    };
    
    int result = solution.solution(clothes);
    System.out.println("결과: " + result);
  }

  public int solution(String[][] clothes) {
    int answer = 1;
    int clothCount = clothes.length;
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    for (int i = 0; i < clothCount; i++) {
      int clothSum = hashMap.getOrDefault(clothes[i][1], 0) + 1;
      hashMap.put(clothes[i][1], clothSum);
    }

    for (int count : hashMap.values()) {
      answer = answer * (count + 1);
    }
    answer = answer - 1;
    return answer;
  }
}
