package bridge

class GameHost(private val bridgeMaker: BridgeMaker, private val bridgeGame: BridgeGame) {
    private lateinit var bridge: List<String>
    private var bridgeCurrentPosition = 0
    private lateinit var recentUserInput: String

    fun makeBridge(bridgeSize: Int) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }
}
