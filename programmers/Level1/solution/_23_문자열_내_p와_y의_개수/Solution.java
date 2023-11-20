package programmers.Level1.solution._23_문자열_내_p와_y의_개수;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */
class Solution {
    public static void main(String[] args) {

        String s = "Pyy";
        boolean expectedResult = false;

        Solution solution = new Solution();
        boolean result = solution.solution(s);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean solution(String s) {
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

    public boolean solution2(String s) {
        int ps = 0;
        int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p', 'P' -> {
                    ps++;
                }
                case 'y', 'Y' -> {
                    ys++;
                }
            }
        }
        return ps == ys;
    }

    /**
     * 아래와 같이 작성해도 시간복잡도는 O(n) + O(n) + O(n) = O(n) 이므로 변화가 없다.
     * @param s
     * @return
     */
    public boolean solution3(String s) {
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();

        return ps == ys;
    }
}
