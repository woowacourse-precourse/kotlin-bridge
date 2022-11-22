package bridge

import domain.BridgeGame
import view.InputView
import view.OutputView
import java.lang.IllegalArgumentException

private var bridgeSize: Int? = null
private val outputView = OutputView()
private val inputView = InputView()
private val MESSAGE_ERROR = "[ERROR]"

fun main() {
    try {
        bridgeSize()
        println("$bridgeSize\n")
        bridgeGame()
    } catch (e: IllegalArgumentException) {
        println("$MESSAGE_ERROR $e")
        return
    }
}

private fun bridgeSize() {
    println(outputView.printStart())
    println(outputView.printBridgeSize())
    try {
        bridgeSize = inputView.readBridgeSize()
    } catch (e: IllegalArgumentException) {
        println("$MESSAGE_ERROR $e")
    }
}

private fun bridgeGame() {
    val bridgeGame = BridgeGame()
    try {
        bridgeSize?.let { bridgeGame.move(it) }
    } catch (e: IllegalArgumentException) {
        println("$MESSAGE_ERROR $e")
    }
}