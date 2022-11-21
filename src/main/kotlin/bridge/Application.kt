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

fun shortBridge(game: BridgeGame, location: Int): MutableList<String> {
    val reduceList = mutableListOf<String>()
    for (idx in 0..location) {
        reduceList.add(game.bridge[idx])
    }
    return reduceList
}

fun gameStart(game: BridgeGame, tryCount: Int) {
    for (location in 0 until game.bridgeLength) {
        val answer = game.move(location, inputMove())
        if (answer && location < game.bridgeLength - BRIDGE_PADDING) OutputView().printMap(game.bridge, location, true)
        if (answer && location == game.bridgeLength - BRIDGE_PADDING) {
            OutputView().printResult(game.bridge, location, true)
            OutputView().printEnd(true, tryCount)
        }
        if (!answer) {
            if (game.retry(inputRetry())) gameStart(game, tryCount + NEXT_TRY)
            else {
                OutputView().printResult(game.bridge, location, false)
                OutputView().printEnd(false, tryCount)
            }
            break
        }
    }
}

fun inputMove() = InputView().readMoving()

fun inputRetry() = InputView().readGameCommand()
