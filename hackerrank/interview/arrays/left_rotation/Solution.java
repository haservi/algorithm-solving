package hackerrank.interview.arrays.left_rotation;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
  public static void main(String[] args) {
    Result result = new Result();

    List<Integer> sampleList = new ArrayList<>();
    for (int i = 1; i < 6; i++) {
      sampleList.add(i);
    }
    int sampleIndex = 2;
    List<Integer> resultList = result.rotLeft(sampleList, sampleIndex);
    System.out.println("before: " + sampleList.toString());
    System.out.println("result: " + resultList.toString());
  }

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    List<Integer> result = new ArrayList<>();
    int resetIndex = 0;
    int startIndex = d;

    int count = a.size();
    for (int i = 0; i < count; i++) {
      if (startIndex == count) {
        result.add(a.get(resetIndex));
        resetIndex++;
      } else {
        result.add(a.get(startIndex));
        startIndex++;
      }
    }
    return result;
  }

}
