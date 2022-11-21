package bridge.ui

import bridge.Exception.inputNoGameException

class OutputView {
    fun printMap(playerMoves: MutableList<List<String>>) {
        for (upDown in 0..1) {
            var index = 0
            print("[ ")
            while (index < playerMoves.size - 1) {
                print(playerMoves[index][upDown] + " | ")
                index++
            }
            println(playerMoves[index][upDown] + " ]")
        }
    }

    fun printResult(playerMoves: MutableList<List<String>>) {
        println("최종 게임 결과")
        printMap(playerMoves)
    }

    fun printStats(count: Int, message: String) {
        try {
            count.inputNoGameException()
            println("총 시도한 횟수: $count")
            println("게임 성공 여부: $message")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
