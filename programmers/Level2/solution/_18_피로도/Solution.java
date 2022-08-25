package programmers.Level2.solution._18_피로도;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
 */
public class Solution {

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {
                { 80, 20 }, { 50, 40 }, { 30, 10 }
        };

        Solution solution = new Solution();
        int result = solution.solution(k, dungeons);

        System.out.println(result);
    }

    public static boolean[] visited;
    public static int result = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return result;
    }

    public void dfs(int k, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k && !visited[i]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1);
                visited[i] = false;
            }
        }
        result = Math.max(result, depth);
    }
}
