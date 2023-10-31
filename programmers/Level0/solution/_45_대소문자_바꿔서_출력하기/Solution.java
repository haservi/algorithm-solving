package programmers.Level0.solution._45_대소문자_바꿔서_출력하기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuilder sb = new StringBuilder();
        char[] charArray = a.toCharArray();
        for (char c : charArray) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
