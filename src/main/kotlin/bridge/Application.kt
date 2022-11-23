package bridge

fun main() {
    println("다리 건너기 게임을 시작합니다.")
    val bridgeLength = BridgeException().readBridgeSizeError()
    val bridgeUpdown = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    val bridge = mutableListOf<String>()
    var playcount = 1
    while (BridgePlay().playBridge(bridgeLength,bridgeUpdown,bridge))
        playcount = BridgePlay().playCount(playcount,bridgeLength,bridge)
    OutputView().printResult(bridge,BridgePlay().playResult(bridge),playcount)
}
