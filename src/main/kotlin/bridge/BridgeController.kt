package bridge

class BridgeController {
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val input = InputView()
    private val output = OutputView()
    private val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    private lateinit var bridgeGame: BridgeGame

    fun run() {
        makeBridge()
        gameProgress()
    }

    private fun makeBridge() {
        output.printStartGame()
        output.printInputSize()
        val bridgeSize = input.readBridgeSize()
        val bridges = bridgeMaker.makeBridge(bridgeSize)
        bridgeGame = BridgeGame(bridges)
    }

    private fun gameProgress() {
        while (true) {
            move()
        }
    }

    private fun move() {
        output.printInputMove()
        val direction = input.readMoving()
        bridgeGame.move(direction)
        output.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
    }
}