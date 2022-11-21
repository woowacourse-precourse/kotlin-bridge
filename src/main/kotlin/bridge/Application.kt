package bridge

import bridge.resources.*
import bridge.view.InputView
import bridge.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
    println(INPUT_BRIDGE_GAME_START)
    try {
        val bridgeLength = inputLength()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
        println(bridge)
        val game = BridgeGame(bridge, bridgeLength)

        gameStart(game, START_TRY)
    } catch (_: IllegalArgumentException) {
    }
}


fun gameStart(game: BridgeGame, tryCount: Int) {
    for (location in START_LOCATION until game.length) {
        val answer = game.bridge[location] == inputMove()
        val nowBridge = game.move(location)
        output().printMap(nowBridge, answer)
        if (!answer && game.retry(inputRetry())) {
            gameStart(game, tryCount + NEXT_TRY)
            break
        }
        if (location == game.length - BRIDGE_PADDING) output().printResult(nowBridge, answer, tryCount)
    }
}

fun output() = OutputView()

fun inputMove() = InputView().readMoving()

fun inputRetry() = InputView().readGameCommand()

fun inputLength() = InputView().readBridgeSize()