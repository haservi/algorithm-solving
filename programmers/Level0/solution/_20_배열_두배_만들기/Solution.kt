package programmers.Level0.solution._20_배열_두배_만들기

import java.util.*

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120809?language=kotlin
 */
fun main() {
    val numbers: IntArray = intArrayOf(1, 2, 100, -99, 1, 2, 3)

    val result = solution(numbers)
    print("result: " + Arrays.toString(result))
}

fun solution(numbers: IntArray): IntArray {
    for (i in numbers.indices) {
        numbers[i] *= 2
    }
    var answer: IntArray = numbers
    return answer
}