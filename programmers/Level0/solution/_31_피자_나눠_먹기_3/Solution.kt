package programmers.Level0.solution._31_피자_나눠_먹기_3

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120816
*/
fun main() {
    val slice = 7
    val n = 10
    var result = solution(slice, n)
    print("result: " + result)
}

fun solution(slice: Int, n: Int): Int {
    return ((n - 1) / slice) + 1
}
