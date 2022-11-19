package bridge

import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.InputView
import bridge.enums.Status
import bridge.ui.OutputView
import bridge.util.BridgeRandomNumberGenerator

val outputView = OutputView()
val inputView = InputView()
val bridgeNumberGenerator = BridgeRandomNumberGenerator()
val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
val bridgeGame = BridgeGame()

fun main() {
    play()
}

fun play() {
    val bridge = initializer()
    restartOrQuit(bridge)
}

fun initializer(): List<String> {
    outputView.printStart()
    val bridgeSize = inputView.retryReadBridgeSize()
    return bridgeMaker.makeBridge(bridgeSize)
}

fun inGame(bridge: String): Status {
    val moving = inputView.retryReadMoving()
    when (bridgeGame.move(bridge, moving)) {
        Status.CORRECT -> return Status.CORRECT
    }
    return Status.WRONG
}

fun inGameLoop(bridge: List<String>): List<Status> {
    var index = 0
    val progress: MutableList<Status> = mutableListOf()
    do {
        progress.add(inGame(bridge[index])).also { outputView.printMap(bridge, progress) }
        index += 1
    } while (bridgeGame.escape(index, progress))
    return progress
}

fun restartOrQuit(bridge: List<String>) {
    do {
        val progress = inGameLoop(bridge)
        if (progress.last() == Status.CORRECT) {
            break
        }
    } while (bridgeGame.retry(inputView.retryReadGameCommand()))
}