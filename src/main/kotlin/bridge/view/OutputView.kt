package bridge.view

import bridge.view.strings.Message
import bridge.domain.game.BridgeGameResult
import bridge.util.println
import bridge.common.ErrorMessage
import bridge.domain.game.BridgeCrossingMap

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

    fun printMap(map: BridgeCrossingMap) {
        println(buildCrossingMap(map))
    }

    fun printResult(result: BridgeGameResult) {
        println(Message.FinishGame.toString().format(
            buildCrossingMap(result.crossingMap),
            if (result.isSuccess) Message.Success else Message.Failure,
            result.tryCount,
        ))
    }

    fun printError(e: IllegalArgumentException) {
        println("${ErrorMessage.PREFIX} ${e.message}")
    }

    private fun buildCrossingMap(map: BridgeCrossingMap): String = buildString {
        appendLine(buildCrossingMapOf(map.upstairs))
        appendLine(buildCrossingMapOf(map.downstairs))
    }

    private fun buildCrossingMapOf(element: List<Char>): String {
        return element.joinToString(prefix = "[ ", postfix = " ]", separator = " | ")
    }
}
