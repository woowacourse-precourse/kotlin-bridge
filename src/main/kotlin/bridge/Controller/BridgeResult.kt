package bridge.Controller

import bridge.Model.Bridge
import bridge.BridgeGame
import bridge.Model.Constants.Companion.DOWN
import bridge.Model.Constants.Companion.QUIT
import bridge.Model.Constants.Companion.RETRY
import bridge.Model.Constants.Companion.UP
import bridge.Model.PlayerBridge
import bridge.View.OutputView

class BridgeResult {

    private var attemptedNumber = 0
    private val outputView = OutputView()
    private val bridge = Bridge()
    private val bridgeGame = BridgeGame()
    private val playerBridge = PlayerBridge()
    private var resultOfGame = NULL

    fun gameStart() {
        val answerBridge = manageGettingBridge()
        while (true) {
            val selectedBridge = bridgeGame.saveLastResult()
            showMovedResult(answerBridge, selectedBridge)
            if (manageGameSuccessResult(selectedBridge, answerBridge)) break
            when (manageGameFailureResult(selectedBridge)) {
                BREAK -> break
                CONTINUE -> continue
            }
        }
    }

    private fun manageGameSuccessResult(
        selectedBridge: MutableMap<String, List<String>>,
        answerBridge: List<String>
    ): Boolean {
        if (bridgeGame.getSuccessResult(answerBridge)) {
            manageSuccessResult(selectedBridge)
            return true
        }
        return false
    }

    private fun manageGameFailureResult(selectedBridge: MutableMap<String, List<String>>): String {
        var result = NULL
        if (bridgeGame.getFailureResult()) {
            when (manageSelectedRetry(selectedBridge)) {
                RETRY -> result = CONTINUE
                QUIT -> result = BREAK
            }
        }
        return result
    }


    private fun manageSelectedRetry(selectedBridge: MutableMap<String, List<String>>): String {
        when (manageRetryDecision()) {
            RETRY -> return getRetryGame()
            QUIT -> return quitGame(selectedBridge)
        }
        return playerBridge.getRetryAnswer()
    }

    private fun getRetryGame(): String {
        bridgeGame.retry()
        return RETRY
    }

    private fun quitGame(selectedBridge: MutableMap<String, List<String>>): String {
        outputView.printResult(selectedBridge, resultOfGame, attemptedNumber)
        return QUIT
    }

    private fun showMovedResult(answerBridge: List<String>, selectedBridge: MutableMap<String, List<String>>) {
        val playerDirection = playerBridge.getDirection()
        bridgeGame.move(playerDirection, answerBridge)
        selectedBridge[UP]?.let { selectedBridge[DOWN]?.let { it1 -> outputView.printMap(it, it1) } }
    }

    private fun manageGettingBridge(): List<String> {
        outputView.printStartLog()
        val answerBridge = bridge.makeBridge()
        outputView.printNewLine()
        return answerBridge
    }

    private fun manageSuccessResult(selectedBridge: MutableMap<String, List<String>>) {
        attemptedNumber += 1
        resultOfGame = SUCCESS_RESULT
        outputView.printResult(selectedBridge, resultOfGame, attemptedNumber)
    }

    private fun manageRetryDecision(): String {
        attemptedNumber += 1
        resultOfGame = FAIL_RESULT
        return playerBridge.getRetryAnswer()
    }

    companion object {
        const val SUCCESS_RESULT = "성공"
        const val FAIL_RESULT = "실패"

        const val CONTINUE = "CONTINUE"
        const val BREAK = "BREAK"

        const val NULL = ""
    }


}