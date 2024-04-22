package programmers.Level5.solution._01_방의_개수;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49190
 */
public class Solution {

    public static void main(String[] args) {
        int[] arrows = { 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0 };
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(arrows);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] arrows) {
        int answer = 0;

        Map<String, Vertex> vertices = new HashMap<>();

        Vertex vertex = new Vertex(0, 0);
        vertices.put(vertex.id, vertex);
        for (int d : arrows) {
            for (int i = 0; i < 2; i++) {
                int x = vertex.x + dx[d];
                int y = vertex.y + dy[d];
                String id = Vertex.id(x, y);

                if (!vertices.containsKey(id)) {
                    vertices.put(id, new Vertex(x, y));
                } else if (!vertex.connectedVertices.contains(id)) {
                    answer++;
                }

                // 기존에 저장한 정보를 가져와서 새로운 간선 추가
                Vertex temp = vertices.get(id);
                vertex.connectedVertices.add(temp.id);
                temp.connectedVertices.add(vertex.id);
                vertex = vertices.get(id);
            }
        }

        return answer;
    }

    private static final int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    private static final int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static class Vertex {
        public final int x;
        public final int y;
        public final String id;
        public final Set<String> connectedVertices;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = id(x, y);
            this.connectedVertices = new HashSet<>();
        }

        public static String id(int x, int y) {
            return String.format("(%d, %d)", x, y);
        }
    }

}
