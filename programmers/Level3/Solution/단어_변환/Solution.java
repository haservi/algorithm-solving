package programmers.Level3.Solution.단어_변환;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String begin = "hit";
    String target = "cog";
    // String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
    String[] words = { "hzt", "hot", "aot", "aog", "cog" };

    int result = solution.solution(begin, target, words);
    System.out.println("result : " + result);
  }

  int answer;
  boolean[] visited;

  public int solution(String begin, String target, String[] words) {
    answer = 51;
    visited = new boolean[words.length];
    dfs(begin, target, words, 0);

    // 51번째 까지 간 경우 매칭되는 것이 없다고 판단
    if (answer == 51) {
      return 0;
    }
    return answer;
  }

  private void dfs(String begin, String target, String[] words, int count) {
    if (begin.equals(target)) {
      // 재귀적으로 들어온 값 중 작은 값으로 변경
      answer = Math.min(answer, count);
      return;
    }

    for (int i = 0; i < words.length; i++) {
      if (visited[i]) {
        continue;
      }

      // 일치하는 스펠링 개수
      int charSyncCount = 0;
      for (int j = 0; j < begin.length(); j++) {
        if (begin.charAt(j) == (words[i].charAt(j))) {
          charSyncCount++;
        }
      }

      // 스펠링 개수가 1개 빼고 모두 같은 경우
      if (charSyncCount == (begin.length() - 1)) {
        visited[i] = true;
        dfs(words[i], target, words, count + 1);
        visited[i] = false;
      }
    }
  }
}