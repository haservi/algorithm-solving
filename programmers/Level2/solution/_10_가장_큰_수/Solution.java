package programmers.Level2.solution._10_가장_큰_수;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Solution {
    public static void main(String[] args) {
        int[] numbers = { 3, 30, 34, 5, 9 };
        String expectedResult = "9534330";

        Solution solution = new Solution();
        String result = solution.solution(numbers);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(int[] numbers) {
        StringBuilder rlt = new StringBuilder();
        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String aToB = o1 + o2;
                String bToA = o2 + o1;
                int result = bToA.compareTo(aToB);
                return result;
            };
        });

        for (int i = 0; i < strArr.length; i++) {
            rlt.append(strArr[i]);
        }
        // 0인 경우 0 return
        if (strArr[0].equals("0")) {
            return "0";
        }

        return rlt.toString();
    }

    public String solution2(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    // 순서를 바꾼 두 값을 더한 뒤 값이 클 경우 변경
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                // 하나의 문자열로 합침
                .collect(Collectors.joining(""))
                // 0으로만 구성된 경우가 있으며, 문자열의 시작 부분에 0이 반복해서 나타난다면 0하나로 대체
                .replaceAll("^0+", "0");
    }
}
