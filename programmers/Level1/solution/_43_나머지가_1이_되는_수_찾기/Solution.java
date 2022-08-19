package programmers.Level1.solution._43_나머지가_1이_되는_수_찾기;

class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int number = 10;
        int result = solution.solution(number);
        System.out.println(result);

    }

    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1;
    }
}