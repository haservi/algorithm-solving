package programmers.Level2.solution.큰수_만들기;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String number = "1924";
    int k = 2;

    String result = solution.solution(number, k);
    System.out.println("결과: " + result);
  }

  public String solution(String number, int k) {
    StringBuilder stringBuilder = new StringBuilder();
    int index = 0;
    int max = 0;
    int count = number.length() - k;

    // k가 정의한 횟수만큼 전체 순회
    for (int i = 0; i < count; i++) {
      max = 0;
      for (int j = index; j <= k + i; j++) {
        // 해당 number의 가장 큰 값을 저장
        if (max < (number.charAt(j) - '0')) {
          max = (number.charAt(j) - '0');
          index = j + 1;
        }
      }
      stringBuilder.append(max);
    }
    return stringBuilder.toString();
  }
}
