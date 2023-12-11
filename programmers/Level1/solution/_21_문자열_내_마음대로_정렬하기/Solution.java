package programmers.Level1.solution._21_문자열_내_마음대로_정렬하기;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
class Solution {
    public static void main(String[] args) {
        String[] strings = { "sun", "bed", "car" };
        int n = 1;
        String[] expectedResult = { "car", "bed", "sun" };

        Solution solution = new Solution();
        String[] result = solution.solution2(strings, n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 정렬 함수를 이용하여 정렬 후 해당 char값에 맞게 정렬
     */
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        int count = strings.length;

        Arrays.sort(strings);

        for (int i = 0; i < count; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (strings[min].charAt(n) > strings[j].charAt(n)) {
                    min = j;
                }
            }
            String key = strings[min];
            while (min > i) {
                strings[min] = strings[min - 1];
                min--;
            }

            answer[i] = key;
        }

        return answer;
    }

    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);
        });
        return strings;
    }

}
