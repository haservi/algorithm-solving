package programmers.Level4.solution._04_가사_검색;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60060?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
        String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
        int[] expectedResult = { 3, 2, 4, 1, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(words, queries);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String[] words, String[] queries) {
        // 트라이 구성
        Node trie = new Node();
        Node reversedTrie = new Node();
        for (String word : words) {
            trie.add(word, 0);
            reversedTrie.add(new StringBuilder(word).reverse().toString(), 0);
        }

        return Arrays.stream(queries)
                .mapToInt(query -> count(query, trie, reversedTrie))
                .toArray();
    }

    private static class Node {
        private final Map<Integer, Integer> terminals = new HashMap<>();
        private final Map<Character, Node> children = new HashMap<>();

        private void add(String word, int offset) {
            int length = word.length() - offset;
            terminals.put(length, terminals.getOrDefault(length, 0) + 1);

            if (length > 0) {
                char c = word.charAt(offset);
                Node child = children.getOrDefault(c, new Node());
                child.add(word, offset + 1);
                children.put(c, child);
            }
        }

        private int count(String query, int offset) {
            if (query.charAt(offset) == '?') {
                return terminals.getOrDefault(query.length() - offset, 0);
            }

            char c = query.charAt(offset);
            if (!children.containsKey(c))
                return 0;
            return children.get(c).count(query, offset + 1);
        }
    }

    private int count(String query, Node trie, Node reversedTrie) {
        if (query.startsWith("?")) {
            return reversedTrie.count(new StringBuilder(query).reverse().toString(), 0);
        }

        return trie.count(query, 0);
    }

}
