package bridge

class Processor(
    val bridgeMaker: BridgeMaker,
    val bridgeGame: BridgeGame,
    val inputView: InputView,
    val outputView: OutputView,
) {
    var playerPosition = 0
    lateinit var bridgeMap: Array<String>
    lateinit var bridge: List<String>

    fun initBridge() {
        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(bridgeSize)
        initBridgeMap()
    }

    fun initBridgeMap(){
        bridgeMap = Array(2) { "[ N ]".repeat(bridge.size).replace("][", "|") }
    }
}