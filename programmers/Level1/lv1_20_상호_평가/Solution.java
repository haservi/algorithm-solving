package programmers.Level1.lv1_20_상호_평가;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] scores = {
      { 100, 90, 98,  88, 65 },
      { 50,  45, 99,  85, 77 },
      { 47,  88, 95,  80, 67 },
      { 61,  57, 100, 80, 65 },
      { 24,  90, 94,  75, 65 }
    };
    
    String result = solution.solution(scores);
    System.out.println("결과 : " + result);
  }

  public String solution(int[][] scores) {
    StringBuilder answer = new StringBuilder();
    int count = scores.length;
    for (int i = 0; i < count; i++) {

      int mineScore = scores[i][i];
      int sumScore = 0;
      int sameScore = 0;
      int sumCount = 0;
      int arrayMin = scores[0][i];
      int arrayMax = scores[0][i];
      for (int j = 0; j < count; j++) {
        sumScore += scores[j][i];
        sumCount++;
        // 최대값 구하기
        if (arrayMax < scores[j][i]) {
          arrayMax = scores[j][i];
        }
        // 최소값 구하기
        if (scores[j][i] < arrayMin) {
          arrayMin = scores[j][i];
        }
        // 값이 동일한 경우 카운트 증가
        if (scores[j][i] == mineScore) {
          sameScore++;
        }
      }
      // 선택한 값이 최소값과 최대값 사이라면 카운트 증가
      if (arrayMin < mineScore && mineScore < arrayMax) {
        sameScore++;
      }

      if (1 == sameScore) {
        sumScore -= mineScore;
        sumCount--;
      }
      answer.append(getGrade(getScoreAverage(sumScore, sumCount)));

    }
    return answer.toString();
  }

  private float getScoreAverage(int totalScore, int count) {
    return (float) totalScore / count;
  }

  private String getGrade(float score) {
    if (90 <= score) {
      return "A";
    } else if (80 <= score) {
      return "B";
    } else if (70 <= score) {
      return "C";
    } else if (50 <= score) {
      return "D";
    } else {
      return "F";
    }
  }
}