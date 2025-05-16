package programmers.Level0.solution._152_합성수_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120846?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 15;
        int expectedResults = 8;

        Solution solution = new Solution();
        int result = solution.solution(n);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isComposite(i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isComposite(int number) {
        // 0과 1은 합성수가 아니며, 2는 소수
        if (number <= 2) {
            return false;
        }

        // 2보다 큰 짝수는 모두 합성수
        if (number % 2 == 0) {
            return true;
        }

        for (int i = 3; (long) i * i <= number; i += 2) {
            // 1과 자기 자신 외의 약수를 찾았으므로 합성수
            if (number % i == 0) {
                return true;
            }
        }

        return false;
    }
}
