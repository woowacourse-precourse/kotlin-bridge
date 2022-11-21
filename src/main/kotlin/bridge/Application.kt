package bridge

fun main() {
    val bridgeSize = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    var finish: Boolean
    var nowBridge: MutableList<String>
    var tryCount = 0

    do {
        tryCount += 1
        val pair = playing(bridge)
        finish = pair.first
        nowBridge = pair.second
        if (!finish) { finish = BridgeGame().retry(InputView().readGameCommand()) }
    } while (!finish)

    println("\n최종 게임 결과")
    OutputView().printMap(bridge, nowBridge)

    OutputView().printResult(BridgeGame().isRight(bridge, nowBridge), tryCount)
}

fun playing(bridge: List<String>): Pair<Boolean, MutableList<String>> {
    var nowBridge = mutableListOf<String>()

    do {
        if (bridge == nowBridge) { return Pair(true, nowBridge) }
        nowBridge = BridgeGame().move(InputView().readMoving(), nowBridge)
        OutputView().printMap(bridge, nowBridge)
        val state = BridgeGame().isRight(bridge, nowBridge)
    } while (state)

    return Pair(false, nowBridge)
}