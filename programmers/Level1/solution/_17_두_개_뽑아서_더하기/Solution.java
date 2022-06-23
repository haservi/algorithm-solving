package programmers.Level1.solution._17_두_개_뽑아서_더하기;

import java.util.*;

/**
 * 1. TreeSet에 값을 넣은 뒤에 해당 메서드 리턴타입에 맞게 변경한다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test = { 18, 1, 3, 4, 1 };
        int[] result = solution.solution(test);
        System.out.println("결과 : " + Arrays.toString(result));
    }

    public int[] solution(int[] numbers) {
        int count = numbers.length;
        Set<Integer> addArraySet = new TreeSet<Integer>();

        // 값을 TreeSet에 넣기
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j)
                    continue;
                addArraySet.add(numbers[i] + numbers[j]);
            }
        }

        // 실제 리턴할 값으로 변환
        int[] result = new int[addArraySet.size()];
        int index = 0;
        for (int i : addArraySet) {
            result[index] = i;
            index++;
        }

        return result;
    }
}
