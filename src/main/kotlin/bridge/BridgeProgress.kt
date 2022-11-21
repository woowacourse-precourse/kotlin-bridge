package bridge

class BridgeProgress {
    private val bridgeSize = InputView().readBridgeSize()
    private val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    fun progress(): Boolean {
        var isProgressing = true
        while (isProgressing) {
            val moving = InputView().readMoving()
            val map = OutputView().printMap(bridge, 0, moving)
            println(map)
            val isEndedGame = (bridge[0] == "U" && moving == "D") || (bridge[0] == "D" && moving == "U")
            if (isEndedGame) {
                isProgressing = BridgeGame().retry(map, 0, isEndedGame)
            }
        }
        return true
    }
}