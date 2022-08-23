fun main() {

    println("main start")

    val sizes: Array<IntArray> =
            arrayOf(
                    intArrayOf(10, 7),
                    intArrayOf(12, 3),
                    intArrayOf(8, 15),
                    intArrayOf(14, 7),
                    intArrayOf(5, 15)
            )
    var result = solution(sizes)
    print("result: " + result)
}

fun solution(sizes: Array<IntArray>): Int {

    var width = 0
    var height = 0
    var count = sizes.size - 1

    for (x in 0..count) {
        var maxWidth = Math.max(sizes[x][0], sizes[x][1])
        var minHeight = Math.min(sizes[x][0], sizes[x][1])
        width = Math.max(width, maxWidth)
        height = Math.max(height, minHeight)
    }

    return width * height
}
