package programmers.Level0.solution._132_문자열이_몇_번_등장하는지_세기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181871?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "banana";
        String pat = "ana";
        int expectedResults = 2;

        Solution solution = new Solution();
        int result = solution.solution(myString, pat);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.substring(i).startsWith(pat)) {
                answer++;
            }
        }
        return answer;
    }

}
