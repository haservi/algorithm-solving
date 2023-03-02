package programmers.Level1.solution._57_바탕화면_정리;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[] wallpaper = { "..........", ".....#....", "......##..", "...##.....", "....#....." };
        Solution solution = new Solution();
        int[] result = solution.solution(wallpaper);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();

        char[][] wallpaperArr = new char[n][m];
        for (int i = 0; i < n; i++) {
            wallpaperArr[i] = wallpaper[i].toCharArray();
        }

        int rowMin = n;
        int colMin = m;
        int rowMax = 0;
        int colMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wallpaperArr[i][j] == '#') {
                    rowMin = Math.min(i, rowMin);
                    colMin = Math.min(j, colMin);
                    rowMax = Math.max(i, rowMax);
                    colMax = Math.max(j, colMax);
                }
            }
        }

        int[] answer = { rowMin, colMin, rowMax + 1, colMax + 1 };
        return answer;
    }
}
