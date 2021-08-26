package programmers.Level1.lv1_33_문자열_내_p와_y의_개수;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "Pyy";

    boolean result = solution.solution(s);
    System.out.println("결과 : " + result);
  }

  boolean solution(String s) {
    boolean answer = true;

    char[] sCharArray = s.toCharArray();
    int charArrayLength = sCharArray.length;
    int checkCount = 0;

    // y인 경우 카운트 증가 p인 경우 카운트 감소
    for (int i = 0; i < charArrayLength; i++) {
      if (sCharArray[i] == 'y' || sCharArray[i] == 'Y') {
        checkCount++;
        continue;
      }
      if (sCharArray[i] == 'p' || sCharArray[i] == 'P') {
        checkCount--;
        continue;
      }
    }

    // 전체 카운트가 같으면 true 반환
    if (checkCount == 0) {
      answer = true;
    } else {
      answer = false;
    }

    return answer;
  }
}
