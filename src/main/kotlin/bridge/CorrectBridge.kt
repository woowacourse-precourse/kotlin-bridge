package bridge

object CorrectBridge {
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    lateinit var correctBridge: List<String>

    fun createBridge(size: Int) {
        correctBridge = BridgeMaker(bridgeNumberGenerator).makeBridge(size)
    }
}