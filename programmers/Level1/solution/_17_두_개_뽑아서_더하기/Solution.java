package programmers.Level1.solution._17_두_개_뽑아서_더하기;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 */
class Solution {
    public static void main(String[] args) {
        int[] test = { 2, 1, 3, 4, 1 };
        int[] expectedResult = { 2, 3, 4, 5, 6, 7 };

        Solution solution = new Solution();
        int[] result = solution.solution(test);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * TreeSet에 값을 넣은 뒤에 해당 메서드 리턴타입에 맞게 변경
     */
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

    public int[] solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
