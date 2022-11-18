package bridge

class BridgeController {
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val input = InputView()
    private val output = OutputView()
    private val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    private lateinit var bridgeGame: BridgeGame

    fun run() {
        makeBridge()
    }

    private fun makeBridge() {
        output.printStartGame()
        output.printInputSize()
        val bridgeSize = input.readBridgeSize()
        val bridges = bridgeMaker.makeBridge(bridgeSize)
        bridgeGame = BridgeGame(bridges)
    }
}