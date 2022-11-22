package bridge

fun main() {
    val bridgeLength = BridgeException().readBridgeSizeError()
    val bridgeUpdown = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    val bridge = mutableListOf<String>()
    println(bridgeUpdown)
    var playcount = 1
    while (BridgePlay().playBridge(bridgeLength,bridgeUpdown,bridge))
        playcount = BridgePlay().playCount(playcount,bridgeLength,bridge)
    OutputView().printResult(bridge,BridgePlay().playResult(bridge),playcount)
}
