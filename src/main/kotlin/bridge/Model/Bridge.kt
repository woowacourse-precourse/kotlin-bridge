package bridge.Model

import bridge.BridgeMaker
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
            getBridgeLengthException(inputSize)
            return inputSize.toInt()
        } catch(e : IllegalArgumentException){
            println(e.message)
        }
        return getBridgeLength()
    }

    private fun getBridgeLengthException(inputSize : String){
        InputException().checkBridgeLenInputIsNumeric(inputSize)
        InputException().checkBridgeRange(inputSize)
    }

}