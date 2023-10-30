package programmers.Level0.solution._44_문자열_출력하기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int length = str.length();
        
        if (1 <= length && length <= 1000000) {
            System.out.print(str);    
        }
        sc.close();
    }
}
