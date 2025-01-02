package programmers.Level0.solution._126_특정_문자열로_끝나는_가장_긴_부분_문자열_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181872?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "AbCdEFG";
        String pat = "dE";
        String expectedResult = "AbCdE";

        Solution solution = new Solution();
        String result = solution.solution(myString, pat);

        if (result.equals(expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String myString, String pat) {
        int patLength = pat.length();
        int myStringLength = myString.length();

        for (int i = myStringLength - patLength; i >= 0; i--) {
            if (myString.substring(i, i + patLength).equals(pat)) {
                return myString.substring(0, i + patLength);
            }
        }
        return "Unmatched";
    }

}
