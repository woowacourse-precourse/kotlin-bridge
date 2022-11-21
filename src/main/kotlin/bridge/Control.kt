package bridge

import output.Output

class Control {

    private val inputView = InputView()

    fun gameStart() {
        println(Output.GAME_START.output)
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize())
    }
}