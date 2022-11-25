package bridge

class OutputView {
    fun startgame () {
        println("다리 건너기 게임을 시작합니다.\n")}

    fun printMap(output: MutableList<Pair<String, String>>, size : Int) {
        print("[")
        for (i in 0..size-1 step 1) { print("${output[i].first}|") }
        print("${output[size].first}]\n")
        print("[")
        for (i in 0..size-1 step 1) { print("${output[i].second}|") }
        print("${output[size].second}]\n")
        println("")
    }

    fun printResult1(output: MutableList<Pair<String, String>>, size : Int) {
        println("최종 게임 결과")
        printMap(output, size - 1)
    }

    fun printResult2(done: String, playround: Int,) {
        println("\n게임 성공 여부: ${done}")
        println("총 시도한 횟수: ${playround}")
    }
}

