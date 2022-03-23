package programmers.Level2.구명보트;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] people = { 70, 99, 95, 50, 10, 10, 30 };
    int limit = 100;

    int result = solution.solution(people, limit);
    System.out.println("결과: " + result);
  }

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);

    int min = 0;
    for (int max = people.length - 1; min <= max; max--) {
      // 2사람의 무게가 보트허용량이면 함께 구조
      if (people[min] + people[max] <= limit) {
        min++;
      }
      answer++;
    }

    return answer;
  }
}
