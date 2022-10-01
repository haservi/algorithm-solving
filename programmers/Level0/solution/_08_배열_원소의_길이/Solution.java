package programmers.Level0.solution._08_배열_원소의_길이;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120854
 */
public class Solution {

    public static void main(String[] args) {

        String[] strlist = { "We", "are", "the", "world!" };

        Solution soution = new Solution();
        int[] result = soution.solution(strlist);
        System.out.println("result: " + Arrays.toString(result));

    }

    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }

}
