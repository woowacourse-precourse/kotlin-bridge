package bridge

import constant.Message
import constant.Symbol

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStart() {
        println(Message.GAME_START.message)
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
