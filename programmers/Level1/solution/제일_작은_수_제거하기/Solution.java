package programmers.Level1.solution.제일_작은_수_제거하기;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] arr = { 1, 1, 2, 4 };

    int[] result = solution.solution(arr);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public int[] solution(int[] arr) {
    // 길이가 1인 경우 -1 리턴
    if (arr.length == 1) {
      return new int[] { -1 };
    }

    // 기존 배열을 복사해서 정렬
    int[] sortArray = arr.clone();
    Arrays.sort(sortArray);

    int count = arr.length;
    int index = 0;
    for (int i = 0; i < count; i++) {
      // 가장 작은 값과 일치한 경우가 아니라면 순차적으로 배열에 값 삽입
      if (sortArray[0] != arr[i]) {
        arr[index] = arr[i];
        index++;
      }
    }

    // 들어온 배열 수 만큼 배열 생성 후 값 삽입
    int[] answer = new int[index];
    for (int i = 0; i < index; i++) {
      answer[i] = arr[i];
    }
    return answer;

  }
}
