package programmers.Level0.solution._71_간단한_논리_연산;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181916?language=java
 */
class Solution {

    public static void main(String[] args) {
        boolean x1 = false;
        boolean x2 = true;
        boolean x3 = true;
        boolean x4 = true;
        boolean expectedResult = true;

        Solution solution = new Solution();
        boolean result = solution.solution(x1, x2, x3, x4);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return intersection(union(x1, x2), union(x3, x4));
    }

    private boolean union(boolean x, boolean y) {
        if (x || y) {
            return true;
        }
        return false;
    }

    private boolean intersection(boolean x, boolean y) {
        if (x && y) {
            return true;
        }
        return false;
    }

}
