package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (i in 0 until size) {
            var num = bridgeNumberGenerator.generate()
            bridge.add(num.toStringUD())
        }
        return bridge
    }

    private fun Int.toStringUD(): String = if (this == 0) DOWN else UP

    companion object {
        const val UP = "U"
        const val DOWN = "D"
    }
}