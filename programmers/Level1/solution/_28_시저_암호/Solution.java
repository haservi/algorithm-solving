package programmers.Level1.solution._28_시저_암호;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 * 1. 아스키코드표를 참조하여 해당 문자값에서 자연수만큼 더한 값이 더 큰 경우 -26(알파벳 개수)를 한다.
 * 2. 소문자와 대문자의 로직은 비슷하며, 이에 해당하지 않은 경우 공백 처리(제한조건)로 값을 넣는다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "a B z";
        int n = 4;
        String expectedResult = "e F d";

        String result = solution.solution2(s, n);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String s, int n) {
        String answer = "";

        char[] charArray = s.toCharArray();
        int repeatAlphabetCount = 26;
        int count = charArray.length;

        for (int i = 0; i < count; i++) {
            char alphabet = charArray[i];
            if ('a' <= alphabet && alphabet <= 'z') {
                if (alphabet + n <= 'z') {
                    answer += (char) (alphabet + n);
                } else {
                    answer += (char) (alphabet + n - repeatAlphabetCount);
                }
            } else if ('A' <= alphabet && alphabet <= 'Z') {
                if (alphabet + n <= 'Z') {
                    answer += (char) (alphabet + n);
                } else {
                    answer += (char) (alphabet + n - repeatAlphabetCount);
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }

    public String solution2(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                answer.append(c);
            } else {
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                int position = c - offset;
                // 알파벳이 넘어갈 수 도 있어서 나머지 연산 추가
                position = (position + n) % ('Z' - 'A' + 1);
                answer.append((char) (offset + position));
            }
        }
        return answer.toString();
    }

}
