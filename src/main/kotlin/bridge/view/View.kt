package bridge.view

import bridge.data.GameHistory
import bridge.data.GameResult

object View {

    fun printStartGame() = OutputView.printStartGame()

    fun printMap(history: GameHistory) = OutputView.printMap(history)

    fun printResult(result: GameResult) = OutputView.printResult(result)

}