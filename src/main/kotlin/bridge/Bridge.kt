package bridge

import bridge.UI.InputView
import bridge.UI.OutputView

class Bridge {

    private val numberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(numberGenerator)

    fun makeBridge(): List<String> {
        return bridgeMaker.makeBridge(getBridgeLength())
    }

    private fun getBridgeLength(): Int {
        OutputView().printGetBridgeLengthLog()
        val inputSize = InputView().readBridgeSize()
        InputException().checkBridgeLenInputIsNumeric(inputSize)
        return inputSize.toInt()
    }

}