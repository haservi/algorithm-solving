package programmers.Level2.solution._66_숫자_카드_나누기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};
        int expectedResult = 0;

        Solution solution = new Solution();
        int result = solution.solution(arrayA, arrayB);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);

        boolean validGcdA = true;
        for (int b : arrayB) {
            if (b % gcdA == 0) {
                validGcdA = false;
                break;
            }
        }

        boolean validGcdB = true;
        for (int a : arrayA) {
            if (a % gcdB == 0) {
                validGcdB = false;
                break;
            }
        }

        // 유효한 최대값 중 큰 값을 반환
        if (validGcdA && validGcdB) {
            return Math.max(gcdA, gcdB);
        } else if (validGcdA) {
            return gcdA;
        } else if (validGcdB) {
            return gcdB;
        } else {
            return 0;
        }
    }

    // 배열의 모든 원소에 대한 최대공약수를 구하는 함수
    private int gcdArray(int[] array) {
        int result = array[0];
        for (int num : array) {
            result = gcd(result, num);
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
