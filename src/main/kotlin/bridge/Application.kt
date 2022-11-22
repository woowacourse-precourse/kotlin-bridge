package bridge

import domain.BridgeGame
import view.InputView
import view.OutputView
import java.lang.IllegalArgumentException

private val outputView = OutputView()
private val inputView = InputView()
private const val MESSAGE_ERROR = "[ERROR]"

fun main() {
    try {
        val bridgeSize = bridgeSize()
        println("$bridgeSize\n")
        bridgeGame(bridgeSize)
    } catch (e: IllegalArgumentException) {
        println("$MESSAGE_ERROR $e")
        return
    }
}

private fun bridgeSize() : Int {
    println(outputView.printStart())
    println(outputView.printBridgeSize())
    try {
        return inputView.readBridgeSize()
    } catch (e: IllegalArgumentException) {
        println("$MESSAGE_ERROR $e")
    }
    return 0
}

private fun bridgeGame(bridgeSize : Int) {
    val bridgeGame = BridgeGame()
    try {
         bridgeGame.move(bridgeSize)
    } catch (e: IllegalArgumentException) {
        println("$MESSAGE_ERROR $e")
    }
}