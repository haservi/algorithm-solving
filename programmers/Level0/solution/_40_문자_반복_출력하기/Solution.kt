package programmers.Level0.solution._40_문자_반복_출력하기

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120825
*/
fun main() {
    val my_string = "hello"
    val n = 3

    var result = solution(my_string, n)
    print("result: $result")
}

fun solution(my_string: String, n: Int): String {
    var answer: String = ""
    for (c in my_string.toCharArray()) {
        answer += (c + "").repeat(n)
    }
    return answer
}

fun diffSolution(myString: String, n: Int) =
        myString.map { it.toString().repeat(n) }.joinToString("")
