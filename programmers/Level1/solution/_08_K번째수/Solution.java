package programmers.Level1.solution._08_K번째수;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
class Solution {

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
        int[] expectedResult = { 5, 6, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(array, commands);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
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

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            int from = command[0] - 1;
            int to = command[1];
            int k = command[2] - 1;

            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }
        return answer;
    }
}
