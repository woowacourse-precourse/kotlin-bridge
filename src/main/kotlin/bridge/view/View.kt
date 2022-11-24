package bridge.view

import bridge.domain.game.Bridge
import bridge.domain.game.BridgeCrossingMap
import bridge.domain.game.BridgeGameResult

object View {

    fun printStartGame() = OutputView.printStartGame()

    fun printMap(map: BridgeCrossingMap) = OutputView.printMap(map)

    fun printResult(result: BridgeGameResult) = OutputView.printResult(result)

    fun requestBridgeSize(): Int {
        OutputView.printInputBridgeSize()

        return repeatIfThrows(
            tryBlock = InputView::readBridgeSize,
            catchBlock = OutputView::printError,
        )
    }

    fun requestNextFloor(): Bridge.Floor {
        OutputView.printSelectNextFloor()

        return repeatIfThrows(
            tryBlock = InputView::readNextFloor,
            catchBlock = OutputView::printError,
        )
    }

    fun requestRetryGame(): Boolean {
        OutputView.printSelectRetryOrFinishGame()

        return repeatIfThrows(
            tryBlock = InputView::askRetryGame,
            catchBlock = OutputView::printError,
        )
    }

    private inline fun <reified T : Throwable, R> repeatIfThrows(
        tryBlock: () -> R,
        catchBlock: (T) -> Unit,
    ): R {
        while (true) {
            try {
                return tryBlock()
            } catch (t: Throwable) {
                if (t !is T) throw t
                catchBlock(t)
            }
        }
    }
}