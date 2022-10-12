package programmers.Level0.solution._29_피자_나눠_먹기

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120814
 */
fun main() {
    val n = 7
    var result = solution(n)
    print("result: " + result)
}

fun solution(n: Int): Int {
    return (n + 6) / 7
}
