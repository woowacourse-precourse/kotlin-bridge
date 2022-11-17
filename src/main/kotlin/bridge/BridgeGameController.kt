package bridge


class BridgeGameController() {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    fun startGame() {
        outputView.printStartGame()
        val bridge = makeBridge()
        moveBridge(bridge)
        while (bridge.getCurrentLocationHit() != "X") {
            moveBridge(bridge)
        }
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
        outputView.printMap(bridge)
    }
}