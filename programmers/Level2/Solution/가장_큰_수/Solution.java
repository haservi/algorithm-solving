package programmers.Level2.Solution.가장_큰_수;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    // int[] numbers = { 3, 30, 34, 5, 9 };
    int[] numbers = { 9, 5, 34, 3, 30 };
    String result = solution.solution(numbers);
    System.out.println("결과: " + result);
  }

  public String solution(int[] numbers) {
    StringBuilder rlt = new StringBuilder();
    String[] strArr = new String[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      strArr[i] = Integer.toString(numbers[i]);
    }

    Arrays.sort(strArr, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String aToB = o1 + o2;
        String bToA = o2 + o1;
        int result = bToA.compareTo(aToB);
        String resultMent;
        if (result == 0) {
          resultMent = "same";
        } else if (result < 0) {
          resultMent = "big";
        } else {
          resultMent = "small";
        }
        // System.out.println("compare: " + aToB + " vs " + bToA + " -> " + resultMent + ", result: " + o1 + " vs " + o2);
        return result;
      };
    });

    for (int i = 0; i < strArr.length; i++) {
      rlt.append(strArr[i]);
    }
    // 0인 경우 0 return
    if (strArr[0].equals("0")) {
      return "0";
    }

    return rlt.toString();
  }
}
