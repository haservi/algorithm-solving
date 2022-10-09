package programmers.Level0.solution._27_배열_자르기

import java.util.*

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120833
*/
fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    val num1 = 1
    val num2 = 3

    var result = solution(numbers, num1, num2)
    print("result: " + Arrays.toString(result))
}

fun solution(numbers: IntArray, num1: Int, num2: Int): IntArray {
    val count = num2 - num1 + 1
    var answer = IntArray(count)
    var index = num1
    for (i in 0 until count) {
        answer[i] = numbers[index]
        index++
    }
    return answer
}

fun diffSolution(numbers: IntArray, num1: Int, num2: Int): IntArray {
    return numbers.sliceArray(num1..num2)
}
