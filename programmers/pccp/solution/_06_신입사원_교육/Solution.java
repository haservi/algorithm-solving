package programmers.pccp.solution._06_신입사원_교육;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/15009/lessons/121688?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] ability = { 10, 3, 7, 2 };
        int number = 2;
        int expectedResult = 37;

        Solution solution = new Solution();
        int result = solution.solution(ability, number);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = Arrays.stream(ability)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        return pq.stream().reduce(0, Integer::sum);
    }
}
