package bridge.view

import bridge.constants.Message
import bridge.data.GameHistory
import bridge.data.GameResult
import bridge.util.println
import bridge.constants.ErrorMessage

object OutputView {

    fun printStartGame() {
        println(Message.StartGame)
    }

    fun printInputBridgeSize() {
        println(Message.InputBridgeSize)
    }

    fun printSelectNextFloor() {
        println(Message.SelectNextFloor)
    }

    fun printSelectRetryOrFinishGame() {
        println(Message.SelectRetryOrFinishGame)
    }

    fun printMap(history: GameHistory) {
        println(buildHistoryMap(history))
    }

    fun printResult(result: GameResult) {
        println(
            format = Message.FinishGame,
            args = arrayOf(
                buildHistoryMap(result.lastHistory),
                if (result.isSuccess) Message.Success else Message.Failure,
                result.tryCount,
            )
        )
    }

    fun printError(t: Throwable) {
        println("${ErrorMessage.PREFIX} ${t.message}")
    }

    private fun buildHistoryMap(history: GameHistory): String = buildString {
        appendLine(buildHistoryOf(history.upstairs))
        appendLine(buildHistoryOf(history.downstairs))
    }

    private fun buildHistoryOf(data: List<Char>): String {
        return data.joinToString(prefix = "[", postfix = "]", separator = "|") { " $it " }
    }
}
