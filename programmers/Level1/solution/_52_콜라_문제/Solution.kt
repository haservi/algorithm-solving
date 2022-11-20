package programmers.Level1.solution._52_콜라_문제

fun main() {
    val a = 3
    val b = 1
    var n = 20

    var result = solution(a, b, n)
    print("result: $result")
}

fun solution(a: Int, b: Int, n: Int): Int {
    var answer = 0
    var remainBottle: Int
    var currentBottle = n
    while (a <= currentBottle) {
        remainBottle = currentBottle % a
        currentBottle = (currentBottle / a) * b
        answer += currentBottle
        currentBottle += remainBottle
    }
    return answer
}
