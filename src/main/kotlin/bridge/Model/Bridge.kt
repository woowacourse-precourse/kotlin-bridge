package bridge.Model

import bridge.BridgeRandomNumberGenerator
import bridge.InputException
import bridge.View.InputView
import bridge.View.OutputView

class Bridge {

    private val numberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(numberGenerator)

    fun makeBridge(): List<String> {
        return bridgeMaker.makeBridge(getBridgeLength())
    }

    private fun getBridgeLength(): Int {
        OutputView().printGetBridgeLengthLog()
        val inputSize = InputView().readBridgeSize()
        try{
            InputException().checkBridgeLenInputIsNumeric(inputSize)
            return inputSize.toInt()
        } catch(e : IllegalArgumentException){
            println(e.message)
        }
        return getBridgeLength()
    }

}