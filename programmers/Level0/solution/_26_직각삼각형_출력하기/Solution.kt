package programmers.Level0.solution._26_직각삼각형_출력하기

import java.util.Scanner;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120823
*/
fun main() {
    // val (n) = readLine()!!.split(' ').map(String::toInt)
    // val sc: Scanner = Scanner(System.`in`)
    // var n = sc.nextInt()
    val n = 3
    for (i in 0 until n) {
        for (j in 0..i) {
            print("*")
        }
        println()
    }
}