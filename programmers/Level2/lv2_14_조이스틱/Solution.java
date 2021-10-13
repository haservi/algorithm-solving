package programmers.Level2.lv2_14_조이스틱;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String name = "AAA";
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
      while (next < nameLength && name.charAt(next) == 'A') {
        next++;
      }
      int move = i + nameLength - next;

      String moveDirection = "";
      int leftOrRight = 0;
      int foward = i;
      int reverse = nameLength - next;
      if (foward <= reverse) {
        leftOrRight = foward;
        moveDirection = "정방향";
      } else {
        leftOrRight = reverse;
        moveDirection = "역방향";
      }

      int nowMinMove = move + leftOrRight;
      minMove = Math.min(minMove, nowMinMove);
      System.out.println(i + "인덱스 앞 A를 제외한 총 거리는 " + move + "이며, " + moveDirection + "으로 " + leftOrRight + " 이동하였다.(정방향:" + foward + ", 역방향:" + reverse + ")");
      System.out.println("====> " + i + "번째값의 평균 이동 거리는 " + nowMinMove + "이다.");
    }

    System.out.println("****총 알파벳 변경 회수는 " + changeAlpabatCount + "이며, 최소이동 거리는 " + minMove + "이다.****");
    answer = (changeAlpabatCount + minMove);

    return answer;
  }
}
