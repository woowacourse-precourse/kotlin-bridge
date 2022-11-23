package bridge.view

import bridge.constants.Message
import bridge.domain.game.GameHistory
import bridge.domain.game.GameResult
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
        println(Message.FinishGame.toString().format(
            buildHistoryMap(result.lastHistory),
            if (result.isSuccess) Message.Success else Message.Failure,
            result.tryCount,
        ))
    }

    fun printError(e: IllegalArgumentException) {
        println("${ErrorMessage.PREFIX} ${e.message}")
    }

    private fun buildHistoryMap(history: GameHistory): String = buildString {
        appendLine(buildHistoryOf(history.upstairs))
        appendLine(buildHistoryOf(history.downstairs))
    }

    private fun buildHistoryOf(data: List<Char>): String {
        return data.joinToString(prefix = "[", postfix = "]", separator = "|") { " $it " }
    }
}
