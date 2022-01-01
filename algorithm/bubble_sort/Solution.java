package algorithm.bubble_sort;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    int[] bubbleArray = {10, 5, 2, 1, 8};

    Solution solution = new Solution();
    int[] result = solution.BubbleSort(bubbleArray);

    System.out.println("정렬된 값: " + Arrays.toString(result));
  }

  public int[] BubbleSort(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length - i; j++) {
        if(arr[j - 1] > arr[j]) {  
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr;
  }
  
}