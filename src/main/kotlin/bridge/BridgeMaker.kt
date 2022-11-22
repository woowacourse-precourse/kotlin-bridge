package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = arrayListOf<String>()
        repeat(size) {
            when (bridgeNumberGenerator.generate()) {
                0 -> bridge.add(GameCommand.DOWN.getCommand())
                1 -> bridge.add(GameCommand.UP.getCommand())
            }
        }
        return bridge
    }
}
