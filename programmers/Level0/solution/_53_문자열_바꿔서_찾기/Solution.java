package programmers.Level0.solution._53_문자열_바꿔서_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181864?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "ABBAA";
        String pat = "AABB";
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(myString, pat);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        for (char c : pat.toCharArray()) {
            if (c == 'A') {
                sb.append("B");
            } else {
                sb.append("A");
            }
        }
        if (myString.contains(sb.toString())) {
            return 1;
        }
        return 0;
    }
}
