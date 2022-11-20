package bridge.model

class Bridge {
    lateinit var bridge: List<String>

    fun makeBridge(size: Int) {
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    }
}