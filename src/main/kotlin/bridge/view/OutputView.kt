package bridge.view

import bridge.domain.Path
import bridge.domain.Player
import bridge.util.Constant.OPEN_PARENTHESIS
import bridge.util.Constant.CLOSE_PARENTHESIS
import bridge.util.Constant.BOUNDARY
import bridge.util.Constant.EMPTY
import kotlin.text.StringBuilder

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printMap(player: Player, bridge: List<String>) {
        makeMap(player, bridge)
        println(upBuilder)
        println(downBuilder)
    }

    private fun makeMap(player: Player, bridge: List<String>) {
        surroundMap(OPEN_PARENTHESIS)
        val state = player.getState()
        state.forEachIndexed() { index, move ->
            printPlayerPosition(bridge[index], move)
            printBridgeInMap(index, state.size)
        }
        surroundMap(CLOSE_PARENTHESIS)
    }

    private fun printBridgeInMap(index: Int, size: Int) {
        if (size - 1 > index) {
            upBuilder.append(BOUNDARY)
            downBuilder.append(BOUNDARY)
        }
    }

    private fun printPlayerPosition(bridgeState: String, move: String) {
        when (bridgeState) {
            Path.UP.getPath() -> {
                upBuilder.append(" $move ")
                downBuilder.append(EMPTY)
            }
            Path.DOWN.getPath() -> {
                upBuilder.append(EMPTY)
                downBuilder.append(" $move ")
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
