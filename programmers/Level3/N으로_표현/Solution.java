package programmers.Level3.N으로_표현;

import java.util.HashSet;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 5;
    int number = 12;

    int result = solution.solution(n, number);
    System.out.println("result : " + result);
  }

  public int solution(int N, int number) {
    int answer = -1;
    int maxedN = 9;
    Set<Integer>[] setN = new Set[maxedN];
    
    // N만큼 값을 추가
    int temp = N;
    for (int i = 1; i < maxedN; i++) {
      setN[i] = new HashSet<>();
      setN[i].add(temp);
      temp = temp * 10 + N;
    }

    for (int i = 1; i < maxedN; i++) {
      for (int j = 1; j < i; j++) {
        for (Integer a : setN[j]) {
          // 이전의 set값들의 정보를 가져온 뒤 해당 set에 값을 추가(set은 중복 허용 안함)
          for (Integer b : setN[i - j]) {
            setN[i].add(a + b);
            setN[i].add(a - b);
            setN[i].add(b - a);
            setN[i].add(a * b);
            if (b != 0) {
              setN[i].add(a / b);
            }
            if (a != 0) {
              setN[i].add(b / a);
            }
          }
        }
      }
    }
    // 모두 저장한 뒤 낮은 순서부터 일치하는 값이 있다면 return
    for (int i = 1; i < maxedN; i++) {
      if (setN[i].contains(number)) {
        answer = i;
        break;
      }
    }
    return answer;
  }

}