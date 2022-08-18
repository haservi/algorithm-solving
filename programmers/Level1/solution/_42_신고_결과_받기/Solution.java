package programmers.Level1.solution._42_신고_결과_받기;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] id_list = { "con", "ryan" };
        String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
        int k = 3;

        int[] result = solution.solution(id_list, report, k);

        System.out.println("result = " + Arrays.toString(result));

    }

    public int[] solution(String[] id_list, String[] reports, int k) {

        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        Map<String, Integer> reportedCountMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            reporterInfoMap.put(name, new HashSet<>());
            reportedCountMap.put(name, i);
        }

        for (String report : reports) {
            String reporter = report.split(" ")[0];
            String reported = report.split(" ")[1];
            reporterInfoMap.get(reported).add(reporter);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = reporterInfoMap.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[reportedCountMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
