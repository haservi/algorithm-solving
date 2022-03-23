package programmers.Level2.조이스틱;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String name = "AABAAB";
    int result = solution.solution(name);
    System.out.println("결과: " + result);
  }

  public int solution(String name) {
    int answer = 0;

    int nameLength = name.length();
    int changeAlpabatCount = 0;
    for (int i = 0; i < nameLength; i++) {
      // 알파벳 변경 시 최소값 선정 후 화살표 위아래 변경 횟수 추가
      changeAlpabatCount += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
    }

    // 알파벳의 정방향 최대 이동거리를 최소거리로 지정
    int minMove = nameLength - 1;
    for (int i = 0; i < nameLength; i++) {
      int next = i + 1;
      int nextCountA = 0;
      while (next < nameLength && name.charAt(next) == 'A') {
        next++;
        nextCountA++;
      }

      // 0번쨰 인덱스에서 앞의 A를 제외하고 이동한 거리
      int moveWithoutA = name.length() - nextCountA - 1;
      // System.out.println("movewithA:" + moveWithoutA);

      // 처음부터 i번째 까지 왔다가 돌아가는 방식과 뒤에서 출발하여 i번째 까지 오는 방식중 작은 값 선택
      int min = Math.min(i, name.length() - next);

      // 알파벳을 순회하며 작은 값을 선택
      minMove = Math.min(minMove, moveWithoutA + min);
      // System.out.println(i + "번째값의 평균 이동 거리는 " + (moveWithoutA + min) + "이다.");
    }

    // System.out.println("총 알파벳 변경 회수는 " + changeAlpabatCount + "이며, 최소이동 거리는 " + minMove + "이다.");
    answer = (changeAlpabatCount + minMove);

    return answer;
  }
}
