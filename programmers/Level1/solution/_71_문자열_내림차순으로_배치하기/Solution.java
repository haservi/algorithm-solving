package programmers.Level1.solution._71_문자열_내림차순으로_배치하기;

public class Solution {

    public static void main(String[] args) {
        String s = "Zbcdefg";
        String expectedResult = "gfedcbZ";

        Solution solution = new Solution();
        String result = solution.solution(s);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                // collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
                // supplier: 반환할 객체 생성
                // accumlator: 원소를 어떻게 누적할지 정의(appendCodePoint를 사용해야 문자열에 정수가 들어가지 않고 문자 형식으로 들어감)
                // cobiner: 반환될 객체가 여러개 있을때 어떻게 합칠지 정의
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
