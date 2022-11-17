package bridge

class Judgement {
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private var correctBridgeMap = mutableListOf<String>()

    fun createCorrectBridge(size : Int) {
        correctBridgeMap.clear()
        correctBridgeMap = BridgeMaker(bridgeNumberGenerator).makeBridge(size).toMutableList()
    }
}