package programmers.Level1.solution._74_데이터_분석;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] data = {
                { 1, 20300104, 100, 80 },
                { 2, 20300804, 847, 37 },
                { 3, 20300401, 10, 8 }
        };
        String ext = "date";
        int valExt = 20300501;
        String sort_by = "remain";
        int[][] expectedResult = { { 3, 20300401, 10, 8 }, { 1, 20300104, 100, 80 } };

        Solution solution = new Solution();
        int[][] result = solution.solution(data, ext, valExt, sort_by);

        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int sortTypeIndex = TypeIndex.findType(sort_by).index;
        int extTypeIndex = TypeIndex.findType(ext).index;

        return Arrays.stream(data)
                .filter(item -> item[extTypeIndex] < val_ext)
                .sorted((o1, o2) -> o1[sortTypeIndex] - o2[sortTypeIndex])
                .toArray(int[][]::new);
    }

    enum TypeIndex {
        CODE(0, "code"),
        DATE(1, "date"),
        MAXIMUM(2, "maximum"),
        REMINE(3, "remain");

        private final int index;
        private final String dataName;

        TypeIndex(int index, String dataName) {
            this.index = index;
            this.dataName = dataName;
        }

        public int getIndex() {
            return index;
        }

        public static TypeIndex findType(String dataName) {
            for (TypeIndex typeIndex : TypeIndex.values()) {
                if (dataName.equals(typeIndex.dataName)) {
                    return typeIndex;
                }
            }
            throw new IllegalArgumentException("unknown type");
        }
    }

}
