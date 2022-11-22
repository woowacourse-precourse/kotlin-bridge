package bridge

import output.Output

class Control {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    var numberOfTry = 1
    var bridge = listOf<String>()

    fun gameStart() {
        println(Output.GAME_START.output)
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize())
        markingBridge()
    }

    private fun markingBridge() {
        val markUp = mutableListOf<String>()
        val markDown = mutableListOf<String>()
        for (index in bridge.indices) {
            val mark = bridgeGame.markBridge(inputView.readMoving(), bridge, index)
            bridgeGame.move(mark, markUp, markDown)
            outputView.printMap(markUp, markDown)
            if (bridgeGame.containsX(markUp, markDown)) {
                whetherToRetry(markUp, markDown)
                return
            }
        }
        outputView.printResultSuccess(markUp, markDown, numberOfTry)
    }

    private fun whetherToRetry(markUp: MutableList<String>, markDown: MutableList<String>) {
        val tryAgain = bridgeGame.retry(inputView.readGameCommand())
        if (tryAgain) {
            numberOfTry++
            return markingBridge()
        } else {
            outputView.printResult(markUp, markDown, numberOfTry)
        }
    }
}