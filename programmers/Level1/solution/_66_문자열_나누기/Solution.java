package programmers.Level1.solution._66_문자열_나누기;

public class Solution {

    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(s);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String s) {
        int answer = 0;
        char[] charArray = s.toCharArray();
        char startChar = ' ';
        int sameCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (sameCount == 0) {
                startChar = charArray[i];
                sameCount++;
                answer++;
                continue;
            }
            if (startChar == charArray[i]) {
                sameCount++;
            } else {
                sameCount--;
            }
        }
        return answer;
    }
}
