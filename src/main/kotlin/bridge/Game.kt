package bridge

class Game {
    fun gameStart() {
        val inputView = InputView()
        val size = inputView.readBridgeSize()

        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridge = bridgeMaker.makeBridge(size)
        println(bridge.toString())
    }
}