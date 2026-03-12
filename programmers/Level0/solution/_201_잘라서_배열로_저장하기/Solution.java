package programmers.Level0.solution._201_잘라서_배열로_저장하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120913?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String myStr = "abc1Addfggg4556b";
        int n = 6;
        String[] expectedResult = {"abc1Ad", "dfggg4", "556b"};

        Solution solution = new Solution();
        String[] result = solution.solution(myStr, n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String my_str, int n) {
        List<String> result = new ArrayList<>();

        int len = my_str.length();
        for (int i = 0; i < len; i += n) {
            int end = Math.min(i + n, len);
            result.add(my_str.substring(i, end));
        }

        return result.toArray(new String[0]);
    }

}
