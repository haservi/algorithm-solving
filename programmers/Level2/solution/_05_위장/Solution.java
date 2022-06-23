package programmers.Level2.solution._05_위장;

import java.util.HashMap;

/**
 * 1. 확률 문제이다. 예를 들어 정육각형 주사위A 주사위B 2개로 나오는 경우의 수는 6 * 6으로 36개이다.
 * 2. 그렇지만 주사위 객체 1개도 경우의 수로 인정하게 되면 (7 x 7) - 1로 48개 이다.
 * 3. 여기서 -1은 주사위가 없는 경우라고 생각할 수 있다.
 * 4. 해당 문제도 같은 방식으로 이해하면 각 옷들은 주사위이고 옷의 개수는 주사위의 번호 개수이다.
 * 5. 예를 들어 옷의 종류가 3개이며, 각각 2벌씩이면 ((2 + 1) * (2 + 1) * (2 + 1)) - 1 = 26 이다.
 * 6. 해당 문제의 풀이 방법은 어느 정도 알았지만, hashMap의 확장함수로 getOrDefault가 있다는 것을 알게됐다.
 * 7. getOrDefault의 두 번째 매개변수인 `defaultValue`는 지정된 키로 매핑된 값이 없으면 반환되는 값이다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {
                { "yellowhat", "headgear" },
                { "yellowhat1", "headgear" },
                { "bluesunglasses", "eyewear" },
                { "bluesunglasses1", "eyewear" },
                { "green_turban", "face" },
                { "green_turban1", "face" }
        };

        int result = solution.solution(clothes);
        System.out.println("결과: " + result);
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        int clothCount = clothes.length;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        for (int i = 0; i < clothCount; i++) {
            int clothSum = hashMap.getOrDefault(clothes[i][1], 0) + 1;
            hashMap.put(clothes[i][1], clothSum);
        }

        for (int count : hashMap.values()) {
            answer = answer * (count + 1);
        }
        answer = answer - 1;
        return answer;
    }
}
