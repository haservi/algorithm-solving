package programmers.Level0.solution._83_접미사인지_확인하기;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181908?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_strings = "banana";
        String is_suffix = "ana";
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(my_strings, is_suffix);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String my_string, String is_suffix) {
        List<String> stringList = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            stringList.add(my_string.substring(i));
        }
        
        return stringList.contains(is_suffix) ? 1 : 0;
    }

    /**
     * endsWith 메서드를 사용하여 접미사인지 확인
     */
    public int solution1(String myString, String isSuffix) {
        return myString.endsWith(isSuffix) ? 1 : 0;
    }
}
