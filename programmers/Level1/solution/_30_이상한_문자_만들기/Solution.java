package programmers.Level1.solution._30_이상한_문자_만들기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "try hello world";
        String expectedString = "TrY HeLlO WoRlD";

        String result = solution.solution(s);
        if (expectedString.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");

        boolean isStartCharUpper = true;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) {
                isStartCharUpper = true;
            } else if (isStartCharUpper) {
                str[i] = str[i].toUpperCase();
                isStartCharUpper = false;
            } else {
                str[i] = str[i].toLowerCase();
                isStartCharUpper = true;
            }
            answer += str[i];
        }

        return answer;
    }

    public String solution2(String s) {
        StringBuilder builder = new StringBuilder();
        boolean isUpperOrLower = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                builder.append(c);
                isUpperOrLower = true;
            } else {
                if (isUpperOrLower) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                isUpperOrLower = !isUpperOrLower;
            }

        }
        return builder.toString();
    }

}
