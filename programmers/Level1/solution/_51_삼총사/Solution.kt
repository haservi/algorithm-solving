package programmers.Level1.solution._51_삼총사

/*
https://school.programmers.co.kr/learn/courses/30/lessons/131705
*/
fun main() {
    val number = intArrayOf(-3, -2, -1, 0, 1, 2, 3)
    var result = solution(number)
    print("result: " + result)
}

fun solution(number: IntArray): Int {
    var answer: Int = 0
    for (i in 0 until (number.size - 2)) {
        for (j in i + 1 until (number.size - 1)) {
            for (k in j + 1 until number.size) {
                if ((number[i] + number[j] + number[k]) == 0) {
                    answer++
                }
            }
        }
    }
    return answer
}
