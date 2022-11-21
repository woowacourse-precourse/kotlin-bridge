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
        gameStart(game, tryCount)
    } catch (_: IllegalArgumentException) {
    }
}


fun gameStart(game: BridgeGame, tryCount: Int) {
    for (location in START_LOCATION until game.length) {
        val answer = game.move(location, inputMove())
        val nowBridge = shortBridge(game.bridge, location)
        if (answer && location < game.length - BRIDGE_PADDING) output().printMap(nowBridge, true)
        if (answer && location == game.length - BRIDGE_PADDING) output().printResult(nowBridge, true, tryCount)
        if (!answer && game.retry(inputRetry())) gameStart(game, tryCount + NEXT_TRY)
        if (!answer) {
            output().printResult(nowBridge, false, tryCount)
            break
        }
    }
}

fun shortBridge(bridge: List<String>, location: Int): MutableList<String> {
    val reduceList = mutableListOf<String>()
    for (idx in START_LOCATION..location) {
        reduceList.add(bridge[idx])
    }
    return reduceList
}

fun output() = OutputView()

fun inputMove() = InputView().readMoving()

fun inputRetry() = InputView().readGameCommand()
