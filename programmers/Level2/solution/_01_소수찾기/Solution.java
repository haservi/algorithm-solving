
package programmers.Level2.solution._01_소수찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
class Solution {

    public static void main(String[] args) {
        String numbers = "011";
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(numbers);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private TreeSet<String> set = new TreeSet<>();
    private int count;

    /**
     * 값을 char에 담아서 반복적으로 소수를 찾도록 구현
     */
    public int solution(String numbers) {
        int size = numbers.length();

        // 리스트에 담아줌
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(numbers.charAt(i));
        }

        // 결과를 저장할 리스트
        List<Character> result = new ArrayList<>();

        // nPr에서 r을 계속 늘리면서 순열 알고리즘 수행
        for (int i = 0; i < size; i++) {
            permutation(arr, result, size, i + 1);
        }

        return count;
    }

    public void permutation(List<Character> arr, List<Character> result, int n, int r) {
        if (r == 0) {

            // 0으로 시작하는 부분집합은 제외
            if (result.get(0) != '0') {

                String str = "";
                int size = result.size();
                for (int i = 0; i < size; i++) {
                    str += result.get(i);
                }

                int num = 0;

                // 이미 나온 숫자 조합이 아닐 경우
                if (!set.contains(str)) {
                    num = Integer.parseInt(str);
                    set.add(str);

                    // 소수 판별
                    if (isPrime(num)) {
                        count++;
                    }
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            permutation(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }

    private boolean isPrime(int n) {
        int i;
        int sqrt = (int) Math.sqrt(n);

        // 2는 유일한 짝수 소수
        if (n == 2)
            return true;

        // 짝수와 1은 소수가 아님
        if (n % 2 == 0 || n == 1)
            return false;

        // 제곱근까지만 홀수로 나눠보면 됨
        for (i = 3; i <= sqrt; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    // ---------------------------------------------------------------
    /**
     * Set을 반환하지 않으며, isUsed를 이용해 사용하지 않은 숫자만 찾도록 함
     */
    public int solution2(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }

    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime2(acc)) {
            primes.add(acc);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) {
                continue;
            }

            int nextAcc = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    private boolean isPrime2(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
