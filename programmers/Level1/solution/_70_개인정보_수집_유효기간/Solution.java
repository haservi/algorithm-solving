package programmers.Level1.solution._70_개인정보_수집_유효기간;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = { "A 6", "B 12", "C 3" };
        String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
        int[] expected = { 1, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(today, terms, privacies);

        if (Arrays.equals(expected, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String todayDateStr, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = parseTermData(terms);

        int currentDate = getDate(todayDateStr);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyData = privacies[i].split(" ");
            int termsDays = termMap.getOrDefault(privacyData[1], 0) * 28;

            if (getDate(privacyData[0]) + termsDays <= currentDate) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private Map<String, Integer> parseTermData(String[] terms) {
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] termData = term.split(" ");
            termMap.put(termData[0], Integer.parseInt(termData[1]));
        }

        return termMap;
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

}
