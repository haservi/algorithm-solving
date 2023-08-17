package programmers.Level1.solution._65_둘만의_암호;

public class Solution {

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String expectedResult = "happy";

        Solution solution = new Solution();
        String result = solution.solution(s, skip, index);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] alphabets = s.toCharArray();

        for (char alphabet : alphabets) {
            int count = 1;
            while (count <= index) {
                alphabet++;
                if ('z' < alphabet) {
                    alphabet -= 26;
                }

                if (skip.contains(String.valueOf(alphabet))) {
                    continue;
                } else {
                    count++;
                }
            }
            answer += String.valueOf(alphabet);
        }
        return answer;
    }
}
