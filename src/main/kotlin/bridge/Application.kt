package bridge

fun main() {
    val bridgeSize = InputView().readBridgeSize()

    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    val (nowBridge, tryCount) = playing(bridge)

    OutputView().printResultMap(bridge, nowBridge)

    OutputView().printResult(BridgeGame().isRight(bridge, nowBridge), tryCount)
}

fun miniGame(bridge: List<String>): Pair<Boolean, MutableList<String>> {
    var nowBridge = mutableListOf<String>()

    do {
        if (bridge == nowBridge) {
            return Pair(true, nowBridge)
        }
        nowBridge = BridgeGame().move(InputView().readMoving(), nowBridge)
        OutputView().printMap(bridge, nowBridge)
        val state = BridgeGame().isRight(bridge, nowBridge)
    } while (state)

    return Pair(false, nowBridge)
}

fun playing(bridge: List<String>): Pair<MutableList<String>, Int> {
    var nowBridge: MutableList<String>
    var tryCount = 0

    do {
        tryCount += 1
        val pair = miniGame(bridge)
        var finish = pair.first
        nowBridge = pair.second
        if (!finish) {
            finish = BridgeGame().retry(InputView().readGameCommand())
        }
    } while (!finish)

    return Pair(nowBridge, tryCount)
}