package bridge.domain

import bridge.BridgeRandomNumberGenerator
import bridge.consol.InputView
import bridge.consol.OutputView
import bridge.data.Bridge
import bridge.data.GameResult
import bridge.data.BridgeMap
import bridge.exceptions.ExceptionHandler


class BridgeGameController() {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    private val gameResult = GameResult()
    private val map = BridgeMap()
    val exceptionHandler = ExceptionHandler()
    fun startGame() {
        try {


            outputView.printStartGame()
            val bridge = makeBridge()
            var gameFlag = true
            while (gameFlag) {
                var hit = moveBridge(bridge)
                gameFlag = askRetryGame(bridge, hit)
                if (bridge.finish(hit)) {
                    gameResult.succeed()
                    outputView.printResultGuide()
                    outputView.printMap(map.getMap())
                    gameFlag = closeGame()
                }
            }
        } catch (e: IllegalArgumentException) {

        }
    }

    private fun closeGame(): Boolean {
        outputView.printResult(gameResult.getGameResult())
        return false
    }

    private fun askRetryGame(bridge: Bridge, hit: String): Boolean {

        if (hit == "X") {
            try {
                outputView.printInputGameCommand()
                val gameCommand = inputView.readGameCommand()
                exceptionHandler.checkCommand(gameCommand)
                if (gameCommand == "Q") {
                    outputView.printResultGuide()
                    outputView.printMap(map.getMap())
                    return closeGame()
                }
                if (gameCommand == "R") {
                    bridgeGame.retry(bridge, map)
                    gameResult.attempt++
                    return true
                }
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
                askRetryGame(bridge, hit)
            }
        }
        return true
    }

    private fun makeBridge(): Bridge {
        return try {
            outputView.printInputLength()
            val bridgeSize = inputView.readBridgeSize()
            exceptionHandler.checkSize(bridgeSize)
            return Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize))
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            makeBridge()
        }
    }

    private fun moveBridge(bridge: Bridge): String {
        return try {
            outputView.printInputMove()
            val upDown = inputView.readMoving()
            exceptionHandler.checkUpDown(upDown)
            val hit = bridgeGame.move(bridge, upDown, map)
            outputView.printMap(map.getMap())
            hit
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            moveBridge(bridge)
        }
    }
}