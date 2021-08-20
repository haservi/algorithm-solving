package programmers.Level1.lv1_27_비밀지도;

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 5;
    int[] arr1 = { 9, 20, 28, 18, 11 };
    int[] arr2 = { 30, 1, 21, 17, 28 };
    String[] result = solution.solution(n, arr1, arr2);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    // 경로를 십진수를 이진수로 변경 및 이진수 앞 공백 추가
    int count = n;
    for (int i = 0; i < count; i++) {
      String firstKeyMap = makeZero(Integer.toBinaryString(arr1[i]), count);
      String secondKeyMap = makeZero(Integer.toBinaryString(arr2[i]), count);
      String rowKey = "";
      // System.out.println(firstKeyMap);
      for (int j = 0; j < count; j++) {
        if ((firstKeyMap.charAt(j) == '0') && (secondKeyMap.charAt(j) == '0')) {
          rowKey += " ";
        } else {
          rowKey += "#";
        }
      }
      // System.out.println(rowKey);
      answer[i] = rowKey;
    }
    return answer;
  }

  private String makeZero(String binaryString, int length) {
    int binaryLength = binaryString.length();

    while (binaryLength != length) {
      binaryString = "0" + binaryString;
      binaryLength++;
    }

    return binaryString;
  }

}
