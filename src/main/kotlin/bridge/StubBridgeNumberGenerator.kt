package bridge

class StubBridgeNumberGenerator : BridgeNumberGenerator {
    private val fakeBridge = mutableListOf(0, 1, 1, 1, 0, 1)

    override fun generate(): Int = fakeBridge.removeAt(0)
}
