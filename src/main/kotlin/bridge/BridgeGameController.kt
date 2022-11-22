package bridge

import bridge.consol.InputView
import bridge.consol.Message.QUIT
import bridge.consol.Message.WRONG
import bridge.consol.OutputView
import bridge.data.Bridge
import bridge.data.GameResult
import bridge.data.BridgeMap
import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker


class BridgeGameController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    private val gameResult = GameResult()
    private val map = BridgeMap()
    fun startGame() {
        outputView.printStartGame()
        val bridge = makeBridge()
        var gameFlag = true
        while (gameFlag) {
            var hit = moveBridge(bridge)
            gameFlag = checkGameResult(bridge, hit)
        }
        closeGame()
    }

    private fun makeBridge(): Bridge {
        outputView.printInputLength()
        val bridgeSize = inputView.readBridgeSize()
        return Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize))
    }

    private fun moveBridge(bridge: Bridge): String {
        outputView.printInputMove()
        val upDown = inputView.readMoving()
        val hit = bridgeGame.move(bridge, upDown, map)
        outputView.printMap(map.getMap())
        return hit
    }

    private fun checkGameResult(bridge: Bridge, hit: String): Boolean {
        if (hit == WRONG) {
            return askRetryGame(bridge)
        }
        if (bridge.finish(hit)) {
            gameResult.succeed()
            return false
        }
        return true
    }

    private fun askRetryGame(bridge: Bridge): Boolean {
        outputView.printInputGameCommand()
        val gameCommand = inputView.readGameCommand()
        return checkGameCommand(gameCommand, bridge)
    }

    private fun checkGameCommand(command: String, bridge: Bridge): Boolean {
        if (command == QUIT) {
            outputView.printResultGuide()
            outputView.printMap(map.getMap())
            return false
        }
        bridgeGame.retry(bridge, map)
        gameResult.increase()
        return true
    }

    private fun closeGame() {
        outputView.printResultGuide()
        outputView.printMap(map.getMap())
        outputView.printResult(gameResult.getGameResult())
    }
}