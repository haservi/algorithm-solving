package programmers.Level1.solution._42_신고_결과_받기;

import java.util.*;
import java.util.stream.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
class Solution {
    public static void main(String[] args) {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;
        int[] expectedResult = { 2, 1, 1, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution1(id_list, report, k);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

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

    public int[] solution1(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
        }

        Map<String, Integer> reported = new HashMap<>();

        // 신고자가 신고한 사람 넣기
        for (String r : report) {
            String[] tokens = r.split(" ");
            String reporter = tokens[0];
            String target = tokens[1];

            // 사용자 명단에 신고자 리스트를 넣음("muzi frodo"인 경우 frodo에 muzi를 넣음)
            Set<String> set = reports.get(reporter);
            if (set.contains(target)) {
                continue;
            }

            set.add(target);
            reported.putIfAbsent(target, 0);
            reported.put(target, reported.get(target) + 1);
        }

        Set<String> banned = reported.keySet().stream()
                .filter(id -> reported.get(id) >= k)
                .collect(Collectors.toSet());

        return Arrays.stream(id_list)
                .mapToInt(id -> (int) reports.get(id).stream()
                        .filter(banned::contains)
                        .count())
                .toArray();
    }
}
