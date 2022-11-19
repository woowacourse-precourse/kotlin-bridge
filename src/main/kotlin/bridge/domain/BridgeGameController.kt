package bridge.domain

import bridge.BridgeRandomNumberGenerator
import bridge.consol.InputView
import bridge.consol.OutputView
import bridge.data.Bridge
import bridge.data.GameResult
import bridge.data.BridgeMap


class BridgeGameController() {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    private val gameResult = GameResult()
    private val map = BridgeMap()
    fun startGame() {
        outputView.printStartGame()
        val bridge = makeBridge()
        var gameFlag = true
        var hit =""
        while (gameFlag) {
            hit = moveBridge(bridge)
            gameFlag = askRetryGame(bridge,hit)
            if (bridge.finish(hit)) {
                gameResult.succeed()
                outputView.printResultGuide()
                outputView.printMap(map.getMap())
                gameFlag = closeGame()
            }
        }

    }

    private fun closeGame(): Boolean {
        outputView.printResult(gameResult.getGameResult())
        return false
    }

    private fun askRetryGame(bridge: Bridge, hit:String): Boolean {

        if (hit == "X") {
            outputView.printInputGameCommand()
            val gameCommand = inputView.readGameCommand()
            if (gameCommand == "Q") {
                outputView.printResultGuide()
                outputView.printMap(map.getMap())
                return closeGame()
            }
            if (gameCommand == "R") {
                bridgeGame.retry(bridge)
                gameResult.attempt++
                return true
            }

        }
        return true
    }

    private fun makeBridge(): Bridge {
        outputView.printInputLength()
        val bridgeSIze = inputView.readBridgeSize()
        return Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSIze))
    }

    private fun moveBridge(bridge: Bridge) :String{
        outputView.printInputMove()
        val upDown = inputView.readMoving()
        val hit = bridgeGame.move(bridge, upDown, map)
        outputView.printMap(map.getMap())
        return hit
    }

}