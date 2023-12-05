package programmers.Level3.solution._12_불량_사용자;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
public class Solution {

    public static void main(String[] args) {

        String[] userId = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] bannedId = { "fr*d*", "abc1**" };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(userId, bannedId);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                // *은 임의의 값으로 .으로 변경(정규식에서 .은 줄바꿈 문자를 제외한 모든 문자와 매치)
                .map(banned -> banned.replace('*', '.'))
                // 정규식으로 값이 같으면 배열 추가
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                // banned_id 만큼 순회하여 추가
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) {
                continue;
            }
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

}
