package programmers.Level1.lv1_38_시저_암호;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "a B z";
    int n = 4;

    String result = solution.solution(s, n);
    System.out.println("결과 : " + result);
  }

  public String solution(String s, int n) {
    String answer = "";

    char[] charArray = s.toCharArray();
    int repeatAlphabetCount = 26;
    int count = charArray.length;

    for (int i = 0; i < count; i++) {
      char alphabet = charArray[i];
      if ('a' <= alphabet && alphabet <= 'z') {
        if (alphabet + n <= 'z') {
          answer += (char) (alphabet + n);
        } else {
          answer += (char) (alphabet + n - repeatAlphabetCount);
        }
      } else if ('A' <= alphabet && alphabet <= 'Z') {
        if (alphabet + n <= 'Z') {
          answer += (char) (alphabet + n);
        } else {
          answer += (char) (alphabet + n - repeatAlphabetCount);
        }
      } else {
        answer += " ";
      }
    }
    return answer;
  }
}
