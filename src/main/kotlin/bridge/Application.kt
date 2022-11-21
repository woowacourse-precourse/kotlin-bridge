package bridge

fun main() {
    val bridgeSize = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    do {
        var finish = playing(bridge)
        if (!finish) { finish = BridgeGame().retry(InputView().readGameCommand()) }
    } while (!finish)
}

fun playing(bridge: List<String>): Boolean {
    var nowBridge = mutableListOf<String>()

    do {
        if (bridge == nowBridge) { return true }
        nowBridge = BridgeGame().move(InputView().readMoving(), nowBridge)
        OutputView().printMap(bridge, nowBridge)
        val state = BridgeGame().isRight(bridge, nowBridge)
    } while (state)

    return false
}