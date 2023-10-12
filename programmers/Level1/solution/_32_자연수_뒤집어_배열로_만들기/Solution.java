package programmers.Level1.solution._32_자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        long s = 12345;
        int[] expected = { 5, 4, 3, 2, 1 };

        Solution solution = new Solution();
        int[] result = solution.solution(s);
        if (Arrays.equals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fass");
        }
    }

    public int[] solution(long n) {
        Stack<Long> stack = new Stack<Long>();
        while (n > 0) {
            stack.push(n % 10);
            n = n / 10;
        }
        List<Long> longList = new ArrayList<Long>();
        while (!stack.isEmpty()) {
            longList.add(stack.pop());
        }

        // 값 삽입
        int[] answer = new int[longList.size()];
        int count = longList.size();
        for (int i = 0; i < count; i++) {
            answer[i] = longList.get(count - i - 1).intValue();
        }

        return answer;
    }

    public int[] solution2(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] charArray = reversed.toCharArray();

        int[] answer = new int[charArray.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = charArray[i] - '0';
        }
        return answer;
    }
}
