package bridge

import bridge.resources.*
import bridge.view.InputView
import bridge.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
    println(INPUT_BRIDGE_GAME_START)
    try {
        val bridgeLength = InputView().readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
        val tryCount = START_TRY
        val game = BridgeGame(bridge, bridgeLength)
        println(bridge)
        gameStart(game, tryCount)
    } catch (_: IllegalArgumentException) {
    }
}



fun gameStart(game: BridgeGame, tryCount: Int) {
    for (location in 0 until game.bridgeLength) {
        val answer = game.move(location, inputMove())
        if (answer && location < game.bridgeLength - BRIDGE_PADDING) OutputView().printMap(shortBridge(game.bridge, location), true)
        if (answer && location == game.bridgeLength - BRIDGE_PADDING) OutputView().printResult(shortBridge(game.bridge, location), true, tryCount)
        if (!answer) {
            if (game.retry(inputRetry())) gameStart(game, tryCount + NEXT_TRY)
            else OutputView().printResult(shortBridge(game.bridge, location), false, tryCount)
            break
        }
    }
}

fun shortBridge(bridge: List<String>, location: Int): MutableList<String> {
    val reduceList = mutableListOf<String>()
    for (idx in 0..location) {
        reduceList.add(bridge[idx])
    }
    return reduceList
}
fun inputMove() = InputView().readMoving()

fun inputRetry() = InputView().readGameCommand()
