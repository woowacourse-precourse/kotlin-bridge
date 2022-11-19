package bridge.view

import bridge.domain.BridgeGame
import bridge.domain.Path
import bridge.util.Constant.OPEN_PARENTHESIS
import bridge.util.Constant.CLOSE_PARENTHESIS
import bridge.util.Constant.BOUNDARY
import bridge.util.Constant.EMPTY
import bridge.util.Constant.LOAD_GO
import bridge.util.Constant.LOAD_STOP
import kotlin.text.StringBuilder

class OutputView {

    fun printMap(bridgeGame: BridgeGame) {
        makeMap(bridgeGame.playerRecord(), bridgeGame.getBridge())
        println(upBuilder)
        println(downBuilder)
        printClear()
    }

    private fun printClear() {
        upBuilder.setLength(0)
        downBuilder.setLength(0)
    }

    private fun makeMap(record: List<String>, bridge: List<String>) {
        surroundMap(OPEN_PARENTHESIS)
        record.forEachIndexed() { index, move ->
            val type = compareWith(bridge[index], move)
            printPlayerPosition(move, type)
            printBridgeInMap(index, record.size)
        }
        surroundMap(CLOSE_PARENTHESIS)
    }

    private fun compareWith(bridgeState: String, move: String): String {
        return when (bridgeState) {
            move -> LOAD_GO
            else -> LOAD_STOP
        }
    }

    private fun printBridgeInMap(index: Int, size: Int) {
        if (size - 1 > index) {
            upBuilder.append(BOUNDARY)
            downBuilder.append(BOUNDARY)
        }
    }

    private fun printPlayerPosition(move: String, type: String) {
        when (move) {
            Path.UP.getPath() -> {
                upBuilder.append(" $type ")
                downBuilder.append(EMPTY)
            }
            Path.DOWN.getPath() -> {
                upBuilder.append(EMPTY)
                downBuilder.append(" $type ")
            }
        }
    }

    private fun surroundMap(type: String) {
        when (type) {
            OPEN_PARENTHESIS -> {
                upBuilder.append(OPEN_PARENTHESIS)
                downBuilder.append(OPEN_PARENTHESIS)
            }
            CLOSE_PARENTHESIS -> {
                upBuilder.append(CLOSE_PARENTHESIS)
                downBuilder.append(CLOSE_PARENTHESIS)
            }
        }
    }

    fun printResult() {}

    companion object {
        private val upBuilder = StringBuilder()
        private val downBuilder = StringBuilder()
    }
}
