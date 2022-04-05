package programmers.Level1.Solution.로또의_최고_순위와_최저_순위;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] myNumbers = { 0, 0, 0, 0, 0, 0 };
    int[] winningNumbers = { 1, 2, 3, 9, 5, 6 };

    int[] result = solution.solution(myNumbers, winningNumbers);
    System.out.println("결과: " + Arrays.toString(result));
  }

  public int[] solution(int[] lottos, int[] win_nums) {
    int sameCount = 0;
    int zeroCount = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (lottos[i] == 0) {
          zeroCount++;
          break;
        }
        if (lottos[i] == win_nums[j]) {
          sameCount++;
        }
      }
    }
    int goodResult = rankConvert(sameCount + zeroCount);
    int badResult = rankConvert(sameCount);

    int[] result = { goodResult, badResult };
    return result;
  }

  private int rankConvert(int score) {
    int rank = 0;
    switch (score) {
      case 6:
        rank = 1;
        break;
      case 5:
        rank = 2;
        break;
      case 4:
        rank = 3;
        break;
      case 3:
        rank = 4;
        break;
      case 2:
        rank = 5;
        break;
      case 1:
        rank = 6;
        break;
      case 0:
        rank = 6;
        break;
    }
    return rank;
  }

  public int[] solution1(int[] lottos, int[] winNums) {
    return LongStream.of(
        (lottos.length + 1)
            - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
        (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count())
        .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
        .toArray();
  }

  public int[] solution2(int[] lottos, int[] win_nums) {
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    int zeroCount = 0;

    for (int lotto : lottos) {
      if (lotto == 0) {
        zeroCount++;
        continue;
      }
      map.put(lotto, true);
    }

    int sameCount = 0;
    for (int winNum : win_nums) {
      if (map.containsKey(winNum))
        sameCount++;
    }

    int maxRank = 7 - (sameCount + zeroCount);
    int minRank = 7 - sameCount;
    if (maxRank > 6)
      maxRank = 6;
    if (minRank > 6)
      minRank = 6;

    return new int[] { maxRank, minRank };
  }

}
