package bridge

class BridgeProgress {
    private val bridgeSize = InputView().readBridgeSize()
    private val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    private val upSideList: MutableList<String> = mutableListOf()
    private val downSideList: MutableList<String> = mutableListOf()

    fun progress() {
        var isProgressing = true
        // TODO: 어떻게 증가시킬지, round 변경
        var round = 0
        while (isProgressing) {
            val moving = OutputView().printMap(upSideList, downSideList, round)
            val isEndedGame = (bridge[round] == "U" && moving == "D") || (bridge[round] == "D" && moving == "U")
            if (isEndedGame) {
                val gameCommand = InputView().readGameCommand()
                isProgressing = BridgeGame().retry(gameCommand)
                round = -1
            }
            round++
        }
    }
}