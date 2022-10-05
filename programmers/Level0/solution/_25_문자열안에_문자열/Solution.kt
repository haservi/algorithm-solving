package programmers.Level0.solution._25_문자열안에_문자열

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120908
*/
fun main() {
    val str1 = "ab6CDE443fgh22iJKlmn1o"
    val str2 = "6CD"

    var result = solution(str1, str2)
    print("result: " + result)
}

fun solution(str1: String, str2: String): Int {
    return if (str1.contains(str2)) 1 else 2
}
