package programmers.Level0.solution._178_두_수의_합;

import java.math.BigInteger;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181846?language=java
 */
class Solution {

    public static void main(String[] args) {
        String a = "582";
        String b = "734";
        String expectedResult = "1316";

        Solution solution = new Solution();
        String result = solution.solution(a, b);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String a, String b) {
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        BigInteger sum = numA.add(numB);
        return sum.toString();
    }
}
