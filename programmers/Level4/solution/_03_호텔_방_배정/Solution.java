package programmers.Level4.solution._03_호텔_방_배정;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64063?language=java
 */
public class Solution {

    public static void main(String[] args) {
        long k = 10;
        long[] room_number = { 1, 3, 4, 1, 3, 1 };
        long[] expectedResult = { 1, 3, 4, 2, 5, 6 };

        Solution solution = new Solution();
        long[] result = solution.solution(k, room_number);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long[] solution(long k, long[] roomNumbers) {
        List<Long> answer = new ArrayList<>();

        Map<Long, Node> nodes = new HashMap<>();
        for (long number : roomNumbers) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() + 1;
            }

            Node node = new Node(number);
            nodes.put(number, node);
            if (nodes.containsKey(number - 1)) {
                node.merge(nodes.get(number - 1));
            }
            if (nodes.containsKey(number + 1)) {
                node.merge(nodes.get(number + 1));
            }

            answer.add(number);
        }

        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    private static class Node {
        private int depth = 1;
        private Node parent = null;

        private long max;

        private Node(long value) {
            max = value;
        }

        private boolean isConnected(Node o) {
            return root() == o.root();
        }

        private long max() {
            return root().max;
        }

        private void merge(Node o) {
            if (isConnected(o)) {
                return;
            }

            Node root1 = root();
            Node root2 = o.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else if (root1.depth < root2.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }

            root1.max = root2.max = Math.max(root1.max, root2.max);
        }

        private Node root() {
            if (parent == null)
                return this;
            return parent.root();
        }
    }

}
