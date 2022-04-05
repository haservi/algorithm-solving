package programmers.Level1.Solution.정수_내림차순으로_배치하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    long s = 118372;

    long result = solution.solution(s);
    System.out.println("결과 : " + result);
  }

  public long solution(long n) {
    long answer = 0;

    // list에 해당 수의 1자리수로 나누어 넣기
    List<Long> oneNumberList = new ArrayList<Long>();
    while (n > 0) {
      oneNumberList.add(n % 10);
      n = n / 10;
    }
    // 내림차순 정렬
    Collections.sort(oneNumberList, Collections.reverseOrder());

    // Iterator로 순회하는 방법
    // Iterator<Long> it = oneNumberList.iterator();
    // while (it.hasNext())
    //   System.out.print(it.next() + " ");

    // 문자열에 해당 숫자값 삽입
    String stringNumber = "";
    for (Long number : oneNumberList) {
      stringNumber += number;
    }

    // 문자열 형변환
    answer = Long.parseLong(stringNumber);

    return answer;
  }
}
