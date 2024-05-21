package programmers.Level3.solution._08_단어_변환;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
class Solution {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "hzt", "hot", "aot", "aog", "cog" };
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution1(begin, target, words);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
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

    // ---------------------------------------------------------------
    public int solution1(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.word.equals(target)) {
                return state.step;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];

                if (!isChangeWord(state.word, next)) {
                    continue;
                }

                if (isVisited[i]) {
                    continue;
                }

                isVisited[i] = true;
                queue.add(new State(next, state.step + 1));
            }
        }

        return 0;
    }

    private boolean isChangeWord(String src, String dst) {
        char[] srcArray = src.toCharArray();
        char[] dstArray = dst.toCharArray();

        int diff = 0;
        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i] != dstArray[i]) {
                diff++;
            }
            if (2 <= diff) {
                return false;
            }
        }
        return true;
    }

    private static class State {
        private final String word;
        private final int step;

        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

}
