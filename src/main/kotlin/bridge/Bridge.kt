package bridge

import exception.BridgeSize
import exception.GameOver
import exception.MovingSpace

class Bridge {
    private val numberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(numberGenerator)

    fun make(): List<String> {
        val bridgeSize = BridgeSize()

        bridgeSize.verify()

        return bridgeMaker.makeBridge(bridgeSize.getInput())
    }

    fun selectToMove(): String {
        val movingSpace = MovingSpace()

        movingSpace.verify()

        return movingSpace.getInput()
    }

    fun selectRetryOrQuit(): String {
        val gameOver = GameOver()

        gameOver.verify()

        return gameOver.getInput()
    }
}