package bridge

import bridge.view.OutputView

val outputView = OutputView()

fun main() {
    startGame()
}

private fun startGame() {
    outputView.printGameStartPhrase()
    println()
}
