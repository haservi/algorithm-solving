package programmers.Level0.solution._90_5명씩;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181886?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] names = { "nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx" };
        String[] expectedResult = { "nami", "vex" };

        Solution solution = new Solution();
        String[] result = solution.solution(names);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] names) {
        List<String> answer = new ArrayList<>();

        int members = names.length;
        int index = 0;
        while (index < members) {
            answer.add(names[index]);
            index += 5;
        }

        return answer.stream().toArray(String[]::new);
    }
}
