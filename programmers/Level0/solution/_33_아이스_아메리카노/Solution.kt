package programmers.Level0.solution._33_아이스_아메리카노

import java.util.*

fun main() {
    val money = 15000
    var result = solution(money)
    print("result: " + Arrays.toString(result))

}

fun solution(money: Int) = arrayOf((money / 5500), (money % 5500))