package programmers.Level0.solution._125_특정한_문자를_대문자로_바꾸기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181873?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "programmers";
        String alp = "p";
        String expectedResult = "Programmers";

        Solution solution = new Solution();
        String result = solution.solution(my_string, alp);

        if (result.equals(expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, String alp) {
        String answer = "";
        String[] splits = my_string.split("");
        for (String split : splits) {
            if (split.equals(alp)) {
                answer += split.toUpperCase();
            } else {
                answer += split;
            }
        }
        return answer;
    }

}
