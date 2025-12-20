package programmers.Level0.solution._184_0_떼기

fun main() {
    val n_str = "0010"
    val expectedResult = "10"

    val result = solution(n_str)

    if (expectedResult == result) {
        println("Pass")
    } else {
        println("Fail")
    }
}

fun solution(n_str: String): String {
    return n_str.toInt().toString()
}
