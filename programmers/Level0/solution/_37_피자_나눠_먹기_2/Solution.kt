package programmers.Level0.solution._37_피자_나눠_먹기_2

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120815?language=kotlin
*/
fun main() {
    val n = 10
    var result = solution(n)
    print("result: " + result)
}

fun solution(n: Int): Int {
    return lcm(n, 6) / 6
}

fun gcd(num1: Int, num2: Int): Int = if (num2 != 0) gcd(num2, num1 % num2) else num1

fun lcm(num1: Int, num2: Int): Int = (num1 * num2) / gcd(num1, num2)
