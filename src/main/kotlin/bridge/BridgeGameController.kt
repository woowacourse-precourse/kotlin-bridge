package bridge


class BridgeGameController() {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    private val gameResult = GameResult()
    fun startGame() {
        outputView.printStartGame()
        val bridge = makeBridge()
        var gameFlag = true
        while (gameFlag) {
            moveBridge(bridge)
            gameFlag = askRetryGame(bridge)
            if (bridge.finish()) {
                gameResult.succeed()
                outputView.printResultGuide()
                outputView.printMap(bridge.getMap())
                gameFlag = closeGame()
            }
        }

    }

    private fun closeGame(): Boolean {
        outputView.printResult(gameResult.getGameResult())
        return false
    }

    private fun askRetryGame(bridge: Bridge): Boolean {

        if (bridge.getHit() == "X") {
            outputView.printInputGameCommand()
            val gameCommand = inputView.readGameCommand()
            if (gameCommand == "Q") {
                outputView.printResultGuide()
                outputView.printMap(bridge.getMap())
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

    private fun moveBridge(bridge: Bridge) {
        outputView.printInputMove()
        val upDown = inputView.readMoving()
        bridgeGame.move(bridge, upDown)
        outputView.printMap(bridge.getMap())
    }

}