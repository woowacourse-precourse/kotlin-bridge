package bridge

import output.Output

class Control {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    var numberOfTry = 1

    fun gameStart() {
        println(Output.GAME_START.output)
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize())
        markingBridge(bridge)
    }

    private fun markingBridge(bridge: List<String>) {
        val markUp = mutableListOf<String>()
        val markDown = mutableListOf<String>()
        var tryAgain = false
        var completeGame = false
        for (index in bridge.indices) {
            val mark = bridgeGame.markBridge(inputView.readMoving(), bridge, index)
            bridgeGame.move(mark, markUp, markDown)
            outputView.printMap(markUp, markDown)
            if (bridgeGame.containsX(markUp, markDown)) {
                tryAgain = bridgeGame.retry(inputView.readGameCommand())
                if (tryAgain) {
                    numberOfTry++
                    break
                } else {
                    outputView.printResult(markUp, markDown, numberOfTry)
                    return
                }
            }
            if (index == (bridge.size - 1)) {
                completeGame = true
            }
        }
        if (tryAgain) {
            markingBridge(bridge)
        }
        if (completeGame) {
            outputView.printResultSuccess(markUp, markDown, numberOfTry)
        }
    }
}