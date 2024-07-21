package programmers.Level2.solution._62_롤케이크_자르기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] topping = { 1, 2, 1, 3, 1, 4, 1, 2 };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(topping);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] topping) {
        int answer = 0;

        // 각 토핑의 총 개수를 저장하는 맵
        Map<Integer, Integer> toppingCountMap = new HashMap<>();
        Set<Integer> leftToppingSet = new HashSet<>();
        Set<Integer> rightToppingSet = new HashSet<>();

        for (int top : topping) {
            toppingCountMap.put(top, toppingCountMap.getOrDefault(top, 0) + 1);
            rightToppingSet.add(top);
        }

        // 한 위치씩 이동하면서 비교(우측의 토핑은 같거나 적어지므로)
        for (int i = 0; i < topping.length - 1; i++) {
            int top = topping[i];
            leftToppingSet.add(top);
            toppingCountMap.put(top, toppingCountMap.get(top) - 1);
            if (toppingCountMap.get(top) == 0) {
                rightToppingSet.remove(top);
            }
            // 두 집합의 크기가 같다면 정답 증가
            if (leftToppingSet.size() == rightToppingSet.size()) {
                answer++;
            }
        }

        return answer;
    }
}
