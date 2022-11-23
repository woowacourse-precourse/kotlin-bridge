package bridge.view

import bridge.data.Bridge
import bridge.data.GameHistory
import bridge.data.GameResult

object View {

    fun printStartGame() = OutputView.printStartGame()

    fun printMap(history: GameHistory) = OutputView.printMap(history)

    fun printResult(result: GameResult) = OutputView.printResult(result)

    fun requestBridgeSize(): Int {
        return repeatIfThrows(
            tryBlock = {
                OutputView.printInputBridgeSize()
                InputView.readBridgeSize()
            },
            catchBlock = OutputView::printError,
        )
    }

    fun requestNextFloor(): Bridge.Floor {
        return repeatIfThrows(
            tryBlock = {
                OutputView.printSelectNextFloor()
                InputView.readMoving()
            },
            catchBlock = OutputView::printError,
        )
    }

    fun requestRetryGame(): Boolean {
        return repeatIfThrows(
            tryBlock = {
                OutputView.printSelectRetryOrFinishGame()
                InputView.askRetryGame()
            },
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