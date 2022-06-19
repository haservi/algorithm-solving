package programmers.Level1.solution.정수_제곱근_판별;

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
