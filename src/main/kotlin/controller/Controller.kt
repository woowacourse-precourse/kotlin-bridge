package controller

import model.BridgeGame
import utils.Messages.ERROR_BRIDGE_SIZE
import utils.Messages.ERROR_PREFIX
import utils.Messages.ERROR_RETRY_INPUT
import utils.Messages.FAIL
import utils.Messages.MOVE_FAIL
import utils.Messages.QUIT
import utils.Messages.RESTART
import utils.Messages.SUCCESS
import view.InputView
import view.OutputView

class Controller {
    var retry = true
    var resultGame = FAIL
    var countRetry = 0
    var gameResult = mutableListOf<Int>()
    fun run() {
        val answerMove = startGame()
        while (retry) {
            gameResult = totalGame(answerMove)
            if (gameResult[0] == 1) {
                retry = BridgeGame().retry(askRetry())
                countRetry += 1
                println("countRetry: $countRetry")
            }
            if (gameResult[2] == answerMove.size && gameResult[0] == 0) {
                resultGame = "성공"
                countRetry += 1
                break
            }
        }
        finalGame(resultGame)
        resultGame(countRetry)
    }

    private fun startGame(): List<String> {
        OutputView().printGameStart()
        OutputView().printBridgeLen()
        val bridgeSize = InputView().readBridgeSize()
//        try {
//            checkRightInputBridgeSize(bridgeSize)
//        } catch (e: IllegalArgumentException) {
//            println(ERROR_PREFIX+ERROR_BRIDGE_SIZE)
//            startGame()
//        }
        val answerMove = BridgeGame().getAnswerMove(bridgeSize.toInt())
        println()
        return answerMove
    }

    private fun checkRightInputBridgeSize(bridgeSize: String) {
        if (bridgeSize.toInt() < 3 || bridgeSize.toInt() > 20) {
            throw IllegalArgumentException()
        }
//        if () {
//
//        }
    }

    private fun totalGame(answerMove: List<String>): MutableList<Int> {
        var trialCount = 0
        var gameOver = mutableListOf<Int>(0, 0, 0)
        val moveHashmapList = mutableListOf<HashMap<String, String>>()
        while (true) {
            gameOver = singleGame(answerMove, trialCount, moveHashmapList)
            trialCount += 1
            if (gameOver[0] == 1) return gameOver
            if (gameOver[2] == answerMove.size) return gameOver
        }
    }

    private fun singleGame(
        answerMove: List<String>,
        trialCount: Int,
        moveHashmapList: MutableList<HashMap<String, String>>
    ): MutableList<Int> {
        val gameOver = mutableListOf<Int>(0, 0, 0)
        OutputView().printMoveTarget()
        val moveInput = InputView().readMoving().trim()
        val resultMoveHashmap = BridgeGame().move(moveInput, answerMove[trialCount])
        moveHashmapList.add(trialCount, resultMoveHashmap)
        gameOver[2] = moveHashmapList.size
        if (resultMoveHashmap.containsValue(MOVE_FAIL)) gameOver[0] = 1
        showTotalMove(trialCount, moveHashmapList)
        return gameOver
    }

    private fun askRetry(): String {
        OutputView().printAskGameResult()
        val inputGameRestartCommand = InputView().readGameCommand()
//        try {
//            checkRightInputRepeat(inputGameRestartCommand)
//        } catch (e: IllegalArgumentException) {
//            println(ERROR_PREFIX+ERROR_RETRY_INPUT)
//            askRetry() // TODO: 다시 입력시 콘솔의 이전 입력을 그대로 최신 입력으로 활용하는 이슈
//        }
        return inputGameRestartCommand
    }

    private fun checkRightInputRepeat(inputGameRestartCommand: String) {
        if (inputGameRestartCommand != RESTART && inputGameRestartCommand != QUIT) {
            throw IllegalArgumentException()
        }
    }

    private fun showTotalMove(trialCount: Int, moveHashmapList: MutableList<HashMap<String, String>>) {
        if (trialCount == 0) {
            OutputView().printSingleResult(moveHashmapList)
        } else {
            val totalMovePath = OutputView().printMap(trialCount, moveHashmapList)
            println(totalMovePath[0])
            println(totalMovePath[1])
        }
    }

    private fun finalGame(resultGame: String) {
        OutputView().printResultFinalGame()
        OutputView().printCheckSuccessGame(resultGame)
    }

    private fun resultGame(trial: Int) {
        OutputView().printNumTotalTrial(trial)
    }

}