package bridge.view

import bridge.constants.Message
import bridge.data.GameHistory

object OutputView {

    fun printStartGame() {
        println("\n${Message.StartGame}")
    }

    fun printInputBridgeSize() {
        println("\n${Message.InputBridgeSize}")
    }

    fun printSelectNextFloor() {
        println("\n${Message.SelectNextFloor}")
    }

    fun printSelectRetryOrFinishGame() {
        println("\n${Message.SelectRetryOrFinishGame}")
    }

    fun printMap(history: GameHistory) {
        println(buildHistoryOf(history.upstairs))
        println(buildHistoryOf(history.downstairs))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    fun printError(message: String) {
        println("[ERROR] $message")
    }

    private fun buildHistoryOf(data: List<Char>): String {
        return data.joinToString(prefix = "[", postfix = "]", separator = "|") { " $it " }
    }
}
