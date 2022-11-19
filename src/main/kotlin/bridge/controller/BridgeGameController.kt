package bridge.controller


import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.InputView
import bridge.enums.Status

import bridge.ui.OutputView
import bridge.util.BridgeRandomNumberGenerator

class BridgeGameController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    private val bridgeGame = BridgeGame()

    fun play() {
        val bridge = initializer()
        val playResult = judgeGameEnd(bridge)
        outputView.printResult(bridge, playResult.first, playResult.second)
    }

    private fun initializer(): List<String> {
        outputView.printStart()
        val bridgeSize = inputView.retryReadBridgeSize()
        return bridgeMaker.makeBridge(bridgeSize)
    }

    private fun playGame(bridge: String): Status {
        val moving = inputView.retryReadMoving()
        when (bridgeGame.move(bridge, moving)) {
            Status.CORRECT -> return Status.CORRECT
        }
        return Status.WRONG
    }

    private fun playGameLoop(bridge: List<String>): List<Status> {
        var index = 0
        val progress: MutableList<Status> = mutableListOf()
        do {
            progress.add(playGame(bridge[index])).also { outputView.printMap(bridge, progress) }
            index += 1
        } while (bridgeGame.escape(index, bridge, progress))
        return progress
    }

    private fun judgeGameEnd(bridge: List<String>): Pair<List<Status>, Int> {
        var progress: List<Status>
        var playCount = 0
        do {
            progress = playGameLoop(bridge).also { playCount += 1 }
            if (progress.last() == Status.CORRECT) {
                break
            }
        } while (bridgeGame.retry(inputView.retryReadGameCommand()))
        return progress to playCount
    }
}