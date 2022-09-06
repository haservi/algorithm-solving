package programmers.Level1.solution._48_핸드_번호_가리기

fun main() {
    var phone_number: String = "01032313231"
    var result = solution(phone_number)
    print("result: " + result)
}

fun solution(phone_number: String): String {
    var answer = StringBuilder()
    
    for (i in phone_number.indices) {
        if (i < phone_number.length - 4) {
            answer.append('*')
        } else {
            answer.append(phone_number.get(i))
        }
    }

    return answer.toString()
}
