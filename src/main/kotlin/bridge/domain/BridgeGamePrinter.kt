package bridge.domain

import bridge.util.Constant

/**
 * 다리 건너기 게임 Print 를 위해 필요한 비즈니스 로직
 */
object BridgeGamePrinter {

    private val upBuilder = StringBuilder()
    private val downBuilder = StringBuilder()

    fun makeMap(bridgeGame: BridgeGame): Pair<StringBuilder, StringBuilder> {
        surroundMap(Constant.OPEN_PARENTHESIS)
        val record = bridgeGame.playerRecord()
        record.forEachIndexed() { index, move ->
            val type = bridgeGame.compareWith(index, move)
            printPlayerPosition(move, type)
            printBridgeInMap(index, record.size)
        }
        surroundMap(Constant.CLOSE_PARENTHESIS)

        return Pair(upBuilder, downBuilder)
    }

    fun printPlayerPosition(move: String, type: String) {
        when (move) {
            Command.UP.value() -> {
                upBuilder.append(" $type ")
                downBuilder.append(Constant.EMPTY)
            }

            Command.DOWN.value() -> {
                upBuilder.append(Constant.EMPTY)
                downBuilder.append(" $type ")
            }
        }
    }

    fun surroundMap(type: String) {
        when (type) {
            Constant.OPEN_PARENTHESIS -> {
                upBuilder.append(Constant.OPEN_PARENTHESIS)
                downBuilder.append(Constant.OPEN_PARENTHESIS)
            }

            Constant.CLOSE_PARENTHESIS -> {
                upBuilder.append(Constant.CLOSE_PARENTHESIS)
                downBuilder.append(Constant.CLOSE_PARENTHESIS)
            }
        }
    }

    fun clear() {
        upBuilder.setLength(0)
        downBuilder.setLength(0)
    }

    private fun printBridgeInMap(index: Int, size: Int) {
        if (size - 1 > index) {
            upBuilder.append(Constant.BOUNDARY)
            downBuilder.append(Constant.BOUNDARY)
        }
    }

    fun getResult(): Pair<StringBuilder, StringBuilder> {
        return Pair(upBuilder, downBuilder)
    }
}
