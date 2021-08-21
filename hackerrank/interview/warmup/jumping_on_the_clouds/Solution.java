package hackerrank.interview.warmup.jumping_on_the_clouds;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    List<Integer> listData = new ArrayList<Integer>();
    listData.add(0);
    listData.add(0);
    listData.add(0);
    listData.add(1);
    listData.add(0);
    listData.add(0);

    int result = Solution.jumpingOnClouds(listData);
    System.out.println("result : " + result);
  }

  public static int jumpingOnClouds(List<Integer> c) {
    int listCount = c.size();
    int count = -1;

    for (int i = 0; i < listCount; i++) {
      if (i + 2 < listCount && c.get(i + 2) == 0) {
        i++;
      }
      count++;
    }
    return count;

  }
}