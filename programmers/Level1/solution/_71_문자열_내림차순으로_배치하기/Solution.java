package programmers.Level1.solution._71_문자열_내림차순으로_배치하기;

public class Solution {

    public static void main(String[] args) {
        String s = "Zbcdefg";
        String expectedResult = "gfedcbZ";

        Solution solution = new Solution();
        String result = solution.solution(s);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
