package bridge.model

class Bridge {
    lateinit var bridge: List<String>

    fun makeBridge(size: Int) {
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    }

    fun compare(direction: String, position: Int) = bridge[position] == direction
}