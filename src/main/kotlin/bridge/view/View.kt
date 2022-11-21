package bridge.view

import bridge.data.GameHistory

object View {

    fun printStartGame() = OutputView.printStartGame()

    fun printMap(history: GameHistory) = OutputView.printMap(history)


}