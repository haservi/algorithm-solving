package programmers.Level0.solution._30_세균_증식

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120910
*/
fun main() {
    val n = 7
    val t = 15

    var result = solution(n, t)
    print("result: " + result)
}

fun solution(n: Int, t: Int): Int {
    var answer = n
    for (num in 1..t) {
        answer *= 2
    }
    return answer
}
