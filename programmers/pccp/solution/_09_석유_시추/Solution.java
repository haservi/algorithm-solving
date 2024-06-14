package programmers.pccp.solution._09_석유_시추;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] land = {
                { 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 1, 1 } };
        int expectedResult = 9;

        Solution solution = new Solution();
        int result = solution.solution(land);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };

    public int solution(int[][] land) {
        int numRows = land.length;
        int numCols = land[0].length;

        int[] columnAreas = new int[numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (land[row][col] == 0) {
                    continue;
                }

                Set<Integer> visitedColumns = new HashSet<>();
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] { row, col });
                int areaSize = 0;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int currentRow = current[0];
                    int currentCol = current[1];

                    if (land[currentRow][currentCol] == 0) {
                        continue;
                    }

                    areaSize++;
                    land[currentRow][currentCol] = 0;
                    visitedColumns.add(currentCol);

                    for (int i = 0; i < 4; i++) {
                        int newRow = currentRow + dx[i];
                        int newCol = currentCol + dy[i];

                        if (0 <= newRow && newRow < numRows && 0 <= newCol && newCol < numCols
                                && land[newRow][newCol] == 1) {
                            queue.add(new int[] { newRow, newCol });
                        }
                    }
                }

                for (int visitedCol : visitedColumns) {
                    columnAreas[visitedCol] += areaSize;
                }
            }
        }

        int maxArea = 0;
        for (int colArea : columnAreas) {
            if (colArea > maxArea)
                maxArea = colArea;
        }
        return maxArea;
    }

}
