package programmers.Level2.lv2_05_전화번호_목록;

import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] phoneBook = { "1194", "1198", "1195524421" };
    boolean result = solution.solution(phoneBook);
    System.out.println("결과: " + result);
  }

  public boolean solution(String[] phone_book) {
    boolean answer = true;

    HashMap<String, Integer> map = new HashMap<>();

    int phoneBookCount = phone_book.length;
    // hashmap에 값 삽입
    for (int i = 0; i < phoneBookCount; i++) {
      map.put(phone_book[i], i);
    }

    // 모든 phone book을 순회하면서 일치하는 값이 있는 경우 false 반환
    for (int i = 0; i < phoneBookCount; i++) {
      for (int j = 0; j < phone_book[i].length(); j++) {
        // System.out.println("키 확인: " + phone_book[i].substring(0, j));
        if (map.containsKey(phone_book[i].substring(0, j))) {
          // System.out.println(phone_book[i]);
          answer = false;
          return answer;
        }
      }
    }

    return answer;
  }
}
