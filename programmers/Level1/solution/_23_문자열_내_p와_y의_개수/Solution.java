package programmers.Level1.solution._23_문자열_내_p와_y의_개수;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 * 1. 문자열의 y값인 경우 count 증가, p인 경우 count 감소한다.
 * 2. count가 같은 경우는 개수가 같거나 아무것도 일치하지 않은 경우이다.
 * 3. 그렇지 않은 경우는 false를 반환한다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "Pyy";

        boolean result = solution.solution(s);
        System.out.println("결과 : " + result);
    }

    boolean solution(String s) {
        boolean answer = true;

        char[] sCharArray = s.toCharArray();
        int charArrayLength = sCharArray.length;
        int checkCount = 0;

        // y인 경우 카운트 증가 p인 경우 카운트 감소
        for (int i = 0; i < charArrayLength; i++) {
            if (sCharArray[i] == 'y' || sCharArray[i] == 'Y') {
                checkCount++;
                continue;
            }
            if (sCharArray[i] == 'p' || sCharArray[i] == 'P') {
                checkCount--;
                continue;
            }
        }

        // 전체 카운트가 같으면 true 반환
        if (checkCount == 0) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}
