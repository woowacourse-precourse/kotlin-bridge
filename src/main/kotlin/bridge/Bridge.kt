package bridge

import exception.BridgeSize
import exception.GameOver
import exception.MovingSpace

class Bridge {
    private val inputView = InputView()
    private val numberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(numberGenerator)

    fun make(): List<String> {
        val bridgeSize = BridgeSize(inputView)

        bridgeSize.verify()

        return bridgeMaker.makeBridge(bridgeSize.getInput())
    }

    fun selectToMove(): String {
        val movingSpace = MovingSpace(inputView)

        movingSpace.verify()

        return movingSpace.getInput()
    }

    fun selectRetryOrQuit(): String {
        val gameOver = GameOver(inputView)

        gameOver.verify()

        return gameOver.getInput()
    }
}