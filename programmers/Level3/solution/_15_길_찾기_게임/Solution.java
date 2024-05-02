package programmers.Level3.solution._15_길_찾기_게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] nodeInfo = {
                { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 },
                { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 }
        };
        int[][] expectedResult = {
                { 7, 4, 6, 9, 1, 8, 5, 2, 3 }, { 9, 6, 5, 8, 1, 4, 3, 2, 7 }
        };

        Solution solution = new Solution();
        int[][] result = solution.solution(nodeInfo);

        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int[][] nodeInfo) {
        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }
        Arrays.sort(nodes, (a, b) -> b.y - a.y);

        Node root = constructTree(nodes);

        List<Integer> preOrder = new ArrayList<>();
        pre(root, preOrder);

        List<Integer> postOrder = new ArrayList<>();
        post(root, postOrder);

        return new int[][] {
                preOrder.stream().mapToInt(Integer::intValue).toArray(),
                postOrder.stream().mapToInt(Integer::intValue).toArray(),
        };
    }

    private static class Node {
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    private Node constructTree(Node[] nodes) {
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    private void insert(Node root, Node node) {
        if (node.x < root.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private void pre(Node node, List<Integer> visits) {
        if (node == null) {
            return;
        }

        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);
    }

    private void post(Node node, List<Integer> visits) {
        if (node == null) {
            return;
        }

        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);
    }
}
