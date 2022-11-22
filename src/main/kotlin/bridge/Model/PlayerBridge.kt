package bridge.Model

import bridge.InputException
import bridge.View.InputView
import bridge.View.OutputView

class PlayerBridge {

    private val outputView = OutputView()
    private val inputView = InputView()
    private val inputException = InputException()

    fun getDirection() : String{
        outputView.printGetPlayerDirectionLog()
        val direction = inputView.readMoving()
        inputException.checkDirectionInput(direction)
        return direction
    }

    fun getRetryAnswer() : String{
        outputView.printRetryLog()
        val retryAnswer = inputView.readGameCommand()
        inputException.checkRetryCommandInput(retryAnswer)
        return retryAnswer
    }

}