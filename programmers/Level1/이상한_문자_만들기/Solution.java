package programmers.Level1.이상한_문자_만들기;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "try hello world";

    String result = solution.solution(s);
    System.out.println("결과 : " + result);
  }

  public String solution(String s) {
    String answer = "";
    String[] str = s.split("");

    boolean isStartCharUpper = true;
    for (int i = 0; i < str.length; i++) {
      if (str[i].equals(" ")) {
        isStartCharUpper = true;
      } else if (isStartCharUpper) {
        str[i] = str[i].toUpperCase();
        isStartCharUpper = false;
      } else {
        str[i] = str[i].toLowerCase();
        isStartCharUpper = true;
      }
      answer += str[i];
    }

    return answer;
  }

  public String failSolution(String s) {
    int splitCount = s.split(" ").length;
    boolean isEven = false;
    // 해당 문자열의 공백 기준 짝수 홀수 판단
    if (splitCount % 2 == 0) {
      isEven = true;
    }

    String answer = "";
    String[] splitString = s.split(" ");
    for (int i = 0; i < splitCount; i++) {
      int splitStringCount = splitString[i].toCharArray().length;
      char[] charArray = splitString[i].toCharArray();
      boolean isStartUpperAndLower = isEven;

      // 공백을 기준으로 자른 문자열의 홀수 짝수에 따라 대소문자 변경
      for (int j = 0; j < splitStringCount; j++) {
        if (i != 0 && j == 0) {
          answer += " ";
        }
        if (isStartUpperAndLower) {
          answer += Character.toLowerCase(charArray[j]);
          isStartUpperAndLower = false;
        } else {
          answer += Character.toUpperCase(charArray[j]);
          isStartUpperAndLower = true;
        }
      }
    }

    return answer;
  }
}
