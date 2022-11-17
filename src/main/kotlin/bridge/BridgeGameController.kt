package bridge


class BridgeGameController() {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    fun startGame() {
        outputView.printStartGame()
        val bridge = makeBridge()
        var gameFlag = true
        while (gameFlag) {
            moveBridge(bridge)
            gameFlag = askRetryGame(bridge)
        }

    }

    private fun askRetryGame(bridge: Bridge): Boolean {

        if (bridge.getCurrentLocationHit() == "X"){
            outputView.printInputGameCommand()
            val gameCommand = inputView.readGameCommand()
            if(gameCommand == "Q"){
                return false
            }
            if (gameCommand == "R"){
                bridgeGame.retry(bridge)
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
        outputView.printMap(bridge.upBridge,bridge.downBridge)
    }

}