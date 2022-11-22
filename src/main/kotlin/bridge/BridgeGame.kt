package bridge

class BridgeGame {

    fun bridgeSetting(): List<String>{
        val bridgeSize = InputView().readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        return bridge
    }

    fun move() {}

    fun retry() {}

}