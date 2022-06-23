package programmers.Level1.solution._19_예산;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 * 1. 적은 부서부터 차례로 예산을 지원하면 최대 한도까지 지원해 줄 수 있다.
 * 2. 그렇기 때문에 해당 배열을 정렬 후 전체 금액 이내 한도까지 값을 더해주면 된다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int budget = 10;
        int[] d = { 2, 2, 3, 3 };
        int result = solution.solution(d, budget);
        System.out.println("결과 : " + result);
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = d.length;

        int answer = 0;
        int sumMoney = 0;
        for (int i = 0; i < count; i++) {
            sumMoney += d[i];
            if (sumMoney <= budget) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

}
