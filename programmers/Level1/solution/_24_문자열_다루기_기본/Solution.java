package programmers.Level1.solution._24_문자열_다루기_기본;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "132234";
        boolean expectedResult = true;

        boolean result = solution.solution(s);
        
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean solution(String s) {
        boolean answer = true;
        // 숫자로 구성된 4또는 6의 길이 정규식
        String regex = "^[0-9]{4}$|^[0-9]{6}$";
        if (s.matches(regex)) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    public boolean solution2(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
