package programmers.Level1.solution._75_가장_많이_받은_선물;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[] friends = { "muzi", "ryan", "frodo", "neo" };
        String[] gifts = {
                "muzi frodo", "muzi frodo", "ryan muzi",
                "ryan muzi", "ryan muzi", "frodo muzi",
                "frodo ryan", "neo muzi" };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(friends, gifts);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        HashMap<String, Integer> friendMap = new HashMap<>();
        int[] giftDegree = new int[friendsLength];
        int[][] giftGraph = new int[friendsLength][friendsLength];

        for (int i = 0; i < friendsLength; i++) {
            friendMap.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] tokens = gift.split(" ");
            giftDegree[friendMap.get(tokens[0])]++;
            giftDegree[friendMap.get(tokens[1])]--;
            giftGraph[friendMap.get(tokens[0])][friendMap.get(tokens[1])]++;
        }

        for (int i = 0; i < friendsLength; i++) {
            int num = 0;
            for (int j = 0; j < friendsLength; j++) {
                if (i == j) {
                    continue;
                }

                if (giftGraph[i][j] > giftGraph[j][i] ||
                        (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
                    num++;
                }
            }

            if (answer < num) {
                answer = num;
            }

        }

        return answer;
    }

}
