package bridge

class StubBridgeNumberGenerator(private val fakeBridge: MutableList<Int>) : BridgeNumberGenerator {
    override fun generate(): Int = fakeBridge.removeAt(0)
}
