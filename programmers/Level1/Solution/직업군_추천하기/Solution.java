package programmers.Level1.Solution.직업군_추천하기;

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] table = { "BI JAVA JAVASCRIPT SQL PYTHON C#", "AONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
        "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "AORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
        "GAME C++ C# JAVASCRIPT C JAVA" };
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
            jobResultMap.put(splitTable[0], jobResultMap.get(splitTable[0]) + (splitTable.length - j) * preference[k]);
          }
        }
      }
    }

    List<String> listKeySet = new ArrayList<>(jobResultMap.keySet());

    Collections.sort(listKeySet, (value1, value2) -> (jobResultMap.get(value2).compareTo(jobResultMap.get(value1))));
    String answer = listKeySet.get(0);
    
    System.out.println(jobResultMap.toString());
    System.out.println(listKeySet.toString());
    return answer;
  }
}

