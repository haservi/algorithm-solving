package programmers.Level1.solution._22_직업군_추천하기;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/84325
 * 1. TreeMap에 `language` 값에 맞는 table의 배열을 맞춘 후 `preference` 값을 더하였다.
 * 2. 이렇게 하면 자동적으로 언어 별 점수의 합이 정렬된다.
 * 3. 이 후 점수 가 큰 순서로 내림차순 한 뒤 첫번째 값을 리턴하였다. 
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] table = {
                "BI JAVA JAVASCRIPT SQL PYTHON C#",
                "AONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "AORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"
        };
        String[] languages = { "JAVA", "JAVASCRIPT" };
        int[] preference = { 7, 5 };

        String result = solution.solution(table, languages, preference);
        System.out.println("결과 : " + result);
    }

    public String solution(String[] table, String[] languages, int[] preference) {

        Map<String, Integer> jobResultMap = new TreeMap<String, Integer>();

        // ValueComparator bvc = new ValueComparator(jobResultMap);
        // TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(bvc);

        int tableCount = table.length;
        for (int i = 0; i < tableCount; i++) {
            String[] splitTable = table[i].split(" ");

            // 해당 점수별로 값 넣기
            jobResultMap.put(splitTable[0], 0);
            for (int j = 1; j < splitTable.length; j++) {
                for (int k = 0; k < languages.length; k++) {
                    if (splitTable[j].equals(languages[k])) {
                        jobResultMap.put(splitTable[0],
                                jobResultMap.get(splitTable[0]) + (splitTable.length - j) * preference[k]);
                    }
                }
            }
        }

        List<String> listKeySet = new ArrayList<>(jobResultMap.keySet());

        Collections.sort(listKeySet,
                (value1, value2) -> (jobResultMap.get(value2).compareTo(jobResultMap.get(value1))));
        String answer = listKeySet.get(0);

        System.out.println(jobResultMap.toString());
        System.out.println(listKeySet.toString());
        return answer;
    }
}
