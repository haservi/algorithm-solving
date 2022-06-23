# 문제 풀이 리뷰

1. 최근 풀었던 1레벨 중에서 조금 고민하게 했던 문제이다.  
방법은 그냥 i에서 j번째의 배열을 뽑아와서 정렬 후에 k번째의 인덱스에 해당하는 값을 새로운 배열에 입력하면 될 것 같았다.
2. 실제로 코드를 짤 때는 조금 많이 길어질 거라 생각됐고 실제로 코드가 길어졌다.
3. 아래 코드는 알고리즘 풀이 후 최상단에 있는 코드이다.

   ```java
   import java.util.Arrays;
   class Solution {
     public int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
       for(int i=0; i<commands.length; i++){
         int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
         Arrays.sort(temp);
         answer[i] = temp[commands[i][2]-1];
       }
       return answer;
     }
   }
   ```

4. 눈에 띄는 부분은 `copyOfRange()` 메소드를 사용했다는 점이다.
5. 해당 메소드는 전달받은 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여 반환한다.
6. 그렇기 때문에 새로운 객체를 만들 필요없이 바로 정렬 후에 값을 넣어 코드가 간결해진다.
