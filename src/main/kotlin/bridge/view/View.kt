package bridge.view

import bridge.data.Bridge
import bridge.data.GameHistory
import bridge.data.GameResult

object View {

    fun printStartGame() = OutputView.printStartGame()

    fun printMap(history: GameHistory) = OutputView.printMap(history)

    fun printResult(result: GameResult) = OutputView.printResult(result)

    fun requestBridgeSize(): Int = repeatIfThrows<IllegalArgumentException, Int>(
        tryBlock = {
            OutputView.printInputBridgeSize()
            InputView.readBridgeSize()
        },
        catchBlock = OutputView::printError,
    )

    fun requestNextFloor(): Bridge.Floor = repeatIfThrows<IllegalArgumentException, Bridge.Floor>(
        tryBlock = {
            OutputView.printSelectNextFloor()
            InputView.readMoving()
        },
        catchBlock = OutputView::printError,
    )

    fun requestRetryGame(): Boolean = repeatIfThrows<IllegalArgumentException, Boolean>(
        tryBlock = {
            OutputView.printSelectRetryOrFinishGame()
            InputView.askRetryGame()
        },
        catchBlock = OutputView::printError,
    )

    private inline fun <reified T : Throwable, R> repeatIfThrows(
        tryBlock: () -> R,
        catchBlock: (t: T) -> Unit,
    ): R {
        var result: R?

        do {
            result = getOrNull(tryBlock, catchBlock)
        } while (result == null)

        return result
    }

    private inline fun <reified T : Throwable, R> getOrNull(
        tryBlock: () -> R,
        catchBlock: (t: T) -> Unit,
    ): R? = try {
        tryBlock()
    } catch (t: Throwable) {
        if (t !is T) {
            throw t
        }

        catchBlock(t)
        null
    }
}