package bridge

import bridge.Constants.Companion.DOWN
import bridge.Constants.Companion.QUIT
import bridge.Constants.Companion.RETRY
import bridge.Constants.Companion.UP
import bridge.UI.OutputView

class BridgeResult {

    private var attemptedNumber = 0
    private val outputView = OutputView()
    private val bridge = Bridge()
    private val bridgeGame = BridgeGame()
    private val playerBridge = PlayerBridge()
    private var resultOfGame = ""

    fun gameStart() {
        outputView.printStartLog()
        val answerBridge = bridge.makeBridge()
        outputView.printNewLine()
        for (i in answerBridge.indices) {
            val playerDirection = playerBridge.getDirection()
            bridgeGame.move(playerDirection, answerBridge)
            val selectedBridge = bridgeGame.saveLastResult()
            selectedBridge[UP]?.let { selectedBridge[DOWN]?.let { it1 -> outputView.printMap(it, it1) } }
            if (bridgeGame.getSuccessResult(answerBridge)) {
                attemptedNumber += 1
                resultOfGame = SUCCESS_RESULT
                outputView.printResult(selectedBridge, resultOfGame, attemptedNumber)
                break
            }
            if (bridgeGame.getFailureResult()) {
                attemptedNumber += 1
                resultOfGame = FAIL_RESULT
                val retryAnswer = playerBridge.getRetryAnswer()
                if (retryAnswer == RETRY) {
                    bridgeGame.retry()
                    continue
                } else if (retryAnswer == QUIT) {
                    outputView.printResult(selectedBridge, resultOfGame, attemptedNumber)
                    break
                }
            }
        }
    }

    companion object {
        const val SUCCESS_RESULT = "성공"
        const val FAIL_RESULT = "실패"
    }


}