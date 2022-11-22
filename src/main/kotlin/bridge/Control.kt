package bridge

import output.Output

class Control {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun gameStart() {
        println(Output.GAME_START.output)
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize())
        markingBridge(bridge)
    }

    private fun markingBridge(bridge: List<String>) {
        val markUp = mutableListOf<String>()
        val markDown = mutableListOf<String>()
        for (index in bridge.indices) {
            val mark = bridgeGame.markBridge(inputView.readMoving(), bridge, index)
            bridgeGame.move(mark, markUp, markDown)
            outputView.printMap(markUp, markDown)
        }
    }
}