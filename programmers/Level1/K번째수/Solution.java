package programmers.Level1.K번째수;

import java.util.Arrays;
import java.util.Collections;

class Solution {

  public static void main(String[] args) {
    System.out.println("");
    Solution solution = new Solution();
    int[] array = { 1, 5, 2, 6, 3, 7, 4 };
    int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
    int[] result = solution.solution(array, commands);
    System.out.println("결과 값 : " + Arrays.toString(result));
  }

  public int[] solution(int[] array, int[][] commands) {
    int resultCount = commands.length;
    int[] answer = new int[resultCount];
    for (int i = 0; i < resultCount; i++) {
      int startSplit = commands[i][0];
      int endSplit = commands[i][1];
      int returnSplit = commands[i][2];
      int tempArrayLength = endSplit - startSplit + 1;
      int[] tempArray = new int[tempArrayLength];

      // 새로운 길이의 배열 생성
      startSplit--;
      for (int j = 0; j < tempArrayLength; j++) {
        tempArray[j] = array[startSplit];
        startSplit++;
      }
      Arrays.sort(tempArray);
      int[] sortArray = tempArray;
      // int[] sortArray = bubbleSort(tempArray);
      answer[i] = sortArray[returnSplit - 1];
    }
    return answer;
  }

  public int[] bubbleSort(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j - 1] > arr[j]) {
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr;
  }
}
