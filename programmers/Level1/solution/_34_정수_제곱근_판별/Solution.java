package programmers.Level1.solution._34_정수_제곱근_판별;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12934
 * 1. sqrt 함수를 이용하여 제곱근값을 출력한 뒤 다시 제곱하여 그값이 일치하는 경우
 * 2. 해당 값에 1을 더한 뒤 제곱하여 리턴한다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        long s = 121;

        long result = solution.solution(s);
        System.out.println("결과 : " + result);
    }

    public long solution(long n) {
        long answer = 0;

        // 제곱근 값 넣기
        long sqrtNumber = (long) Math.sqrt(n);

        // 제곱근 값 일치 여부 확인
        if (n == (sqrtNumber * sqrtNumber)) {
            answer = sqrtNumber + 1;
            answer = answer * answer;
        } else {
            answer = -1;
        }
        return answer;
    }
}
