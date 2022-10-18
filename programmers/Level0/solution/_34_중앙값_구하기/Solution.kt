package programmers.Level0.solution._34_중앙값_구하기

import java.util.*

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120811
*/
fun main() {
    val array = intArrayOf(1, 2, 7, 10, 11)
    var result = solution(array)
    print("result: " + result)
}

fun solution(array: IntArray): Int {
    Arrays.sort(array)
    return array[array.size / 2]
}

fun diffSolution(array: IntArray) = array.sorted()[array.size / 2]