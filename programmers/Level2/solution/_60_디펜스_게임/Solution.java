package programmers.Level2.solution._60_디펜스_게임;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = { 4, 2, 4, 5, 3, 3, 1 };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(n, k, enemy);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
