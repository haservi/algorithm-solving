package programmers.Level1.Solution.다트_게임;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String dartResult = "1D2S#10S2S*";
    int result = solution.solution(dartResult);
    System.out.println("결과 : " + result);
  }

  public int solution(String dartResult) {
    int count = dartResult.length();
    int answer = 0;
    int setScore = 0;

    for (int i = 0; i < count; i++) {
      int score = dartResult.charAt(i) - '0';

      // 점수가 숫자인 경우 계산
      if (0 <= score && score <= 9) {
        // 만약 점수가 10점이면 i++ 해주고 score 10점 변경
        if (dartResult.charAt(i + 1) == '0') {
          score = 10;
          i++;
        }
        int beforeScore = setScore; // 이전 점수 저장
        setScore = 0;
        int checkdBonus = i + 2; // 스타상, 아차상 여부 확인

        // 점수 스코어 가져오기
        int scoreSquared = getScoreSquared(dartResult.charAt(i + 1));

        if (checkdBonus < count && (dartResult.charAt(checkdBonus) == '*' || dartResult.charAt(checkdBonus) == '#')) {
          if (dartResult.charAt(checkdBonus) == '*') {
            // 스코어가 처음이 아니라면 이전 스코어 합산
            if (i != 0) {
              answer += beforeScore;
            }
            setScore = (int) Math.pow(score, scoreSquared) * 2;

          } else if (dartResult.charAt(checkdBonus) == '#') {
            setScore = (int) Math.pow(score, scoreSquared) * -1;
          }

        } else { // 아차상, 스타상이 없는 경우
          setScore = (int) Math.pow(score, scoreSquared);
        }

        answer += setScore;
      }
    }
    return answer;
  }

  private int getScoreSquared(char c) {
    int squared = 0;
    switch (c) {
      case 'S':
        squared = 1;
        break;
      case 'D':
        squared = 2;
        break;
      case 'T':
        squared = 3;
        break;
    }
    return squared;
  }

}
