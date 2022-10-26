package programmers.Level0.solution._40_문자_반복_출력하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120825
 */
public class Solution {

    public static void main(String[] args) {
        String my_string = "hello";
        int n = 3;

        Solution solution = new Solution();
        String result = solution.solution(my_string, n);
        System.out.println("result: " + result);
    }

    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for (char myChar : my_string.toCharArray()) {
            while (n != count) {
                answer.append(myChar);
                count++;
            }
            count = 0;
        }
        return answer.toString();
    }

    public String diffSolution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            sb.append((c + "").repeat(n));
        }
        return sb.toString();
    }
}
