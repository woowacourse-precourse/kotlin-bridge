package bridge.model

class Bridge {
    lateinit var bridge: List<String>

    fun getBridge(size: Int) {
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    }
}