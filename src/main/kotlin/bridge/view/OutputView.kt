package bridge.view

import constant.Message
import constant.Symbol

class OutputView {
    fun printStart() {
        println(Message.GAME_START.message)
    }

    fun printMap(up: List<String>, down: List<String>) {
        printUp(up)
        printDown(down)
    }

    private fun printUp(up: List<String>) {
        print(Symbol.START_BRIDGE.symbol)
        print(up[0])
        for (i in 1 until up.size) {
            print(Symbol.SEPARATOR.symbol)
            print(up[i])
        }
        println(Symbol.END_BRIDGE.symbol)
    }

    private fun printDown(down: List<String>) {
        print(Symbol.START_BRIDGE.symbol)
        print(down[0])
        for (i in 1 until down.size) {
            print(Symbol.SEPARATOR.symbol)
            print(down[i])
        }
        println(Symbol.END_BRIDGE.symbol)
        println()
    }

    fun printResult(up: List<String>, down: List<String>) {
        println(Message.FINAL_GAME_RESULT.message)
        OutputView().printMap(up, down)
    }

    fun printSuccessResult(successResult: String, attempts: Int) {
        println("${Message.GAME_SUCCESS_RESULT.message}${successResult}")
        println("${Message.NUMBER_OF_ATTEMPTS.message}${attempts}")
    }
}
