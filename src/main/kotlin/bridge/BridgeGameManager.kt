package bridge

object BridgeGameManager {

    fun gameStart() {
        OutputView.printStart()
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        OutputView.getBridgeSize()
        val bridge = maker.makeBridge(InputView.readBridgeSize())
        startPlaying(bridge)

    }

    private fun startPlaying(bridge: List<String>) {
        var count = BridgeParameter.StartValue.value
        while (true){
            count++
            val game = BridgeGame()
            game.move(bridge,count)
        }
    }
}