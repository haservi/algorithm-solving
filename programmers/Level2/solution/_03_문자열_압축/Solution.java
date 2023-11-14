package programmers.Level2.solution._03_문자열_압축;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * 1. 문자열의 절반까지 계속하여 문자를 나누어 가장 짧게 압축되는 값을 리턴한다.
 * 2. equals함수를 이용하여 이전에 들어온 값과 비교하여 일치하면 카운트를 추가한다.
 * 3. 결과 중 가장 작은 값은 Math.min함수를 이용하여 리턴하였다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "abcabcabcabcdededededede";
        int expectedResult = 14;

        int result = solution.solution2(test);
        if (expectedResult == result) {

            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int compressLength = getStringCompress(s, i);
            answer = Math.min(answer, compressLength);
        }
        return answer;
    }

    private int getStringCompress(String s, int interval) {
        int duplicateCount = 1;
        int stringLength = s.length();
        String pattern = "";
        String compString = "";

        for (int i = 0; i <= stringLength + interval; i += interval) {
            String nowString = "";
            // 마지막 문자열인 경우
            if (i >= stringLength) {
                nowString = "";
            } else if (stringLength < (i + interval)) {
                nowString = s.substring(i);
            } else {
                nowString = s.substring(i, i + interval);
            }

            // 첫 문자열은 비교안함
            if (i != 0) {
                if (nowString.equals(pattern)) {
                    duplicateCount++;
                } else if (duplicateCount >= 2) {
                    compString += duplicateCount + pattern;
                    duplicateCount = 1;
                } else {
                    compString += pattern;
                }
            }
            pattern = nowString;

        }
        return compString.length();
    }

    // ---------------------------------------------------------------
    public int solution2(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }

    private int compress(String s, int length) {
        StringBuilder builder = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(s, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (1 < count) {
                    builder.append(count);
                }
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (1 < count) {
            builder.append(count);
        }
        builder.append(last);
        return builder.length();
    }

    private List<String> split(String s, int length) {
        List<String> tokens = new ArrayList<>();

        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (s.length() < endIndex) {
                endIndex = s.length();
            }
            tokens.add(s.substring(startIndex, endIndex));
        }
        return tokens;
    }

}
