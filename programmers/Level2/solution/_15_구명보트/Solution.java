package programmers.Level2.solution._15_구명보트;

import java.util.Arrays;

/**
 * 1. 보트의 최대 인원수는 2명이다.
 * 2. 전체 인원을 무게별로 정렬 후 양끝의 합이 허용무게 이내이면 함께 출발한다.
 * 3. 그렇지 않은 경우 무거운 사람 혼자 출발한다.
 */
public class Solution {
    public static void main(String[] args) {

        int[] people = { 70, 99, 95, 50, 10, 10, 30 };
        int limit = 100;

        int result = Solution.solution(people, limit);
        System.out.println("결과: " + result);
    }

    public static int solution(int[] people, int limit) {
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
