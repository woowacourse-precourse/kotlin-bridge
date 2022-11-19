package controller

import model.BridgeGame
import view.InputView
import view.OutputView

class Controller {
    fun run() {
        val answerMove = startGame()
        var retry = true
        var trial = 0
        while (retry) {
            trial = totalGame(answerMove)
            if (trial != answerMove.size) retry = BridgeGame().retry()
            else break
        }
        finalGame()
        resultGame(trial)
    }

    private fun startGame(): List<String> {
        // 다리 건너기 게임을 시작합니다.
        OutputView().printGameStart()

        // 다리의 길이를 입력해주세요.
        OutputView().printBridgeLen()
        val bridgeSize = InputView().readBridgeSize()
        val answerMove = BridgeGame().getAnswerMove(bridgeSize)
        println()
        return answerMove
    }

    private fun totalGame(answerMove: List<String>): Int {
        var trialCount = 0
        var gameOver = false
        val moveHashmapList = MutableList(answerMove.size) { it -> HashMap<String, String>() }
        while (!gameOver) {
            gameOver = singleGame(answerMove, trialCount, moveHashmapList)
            println("trialCount: $trialCount")
            trialCount += 1
            if (trialCount == answerMove.size) {
                break
            }
        }
        return trialCount
    }

    private fun singleGame(answerMove: List<String>, trialCount: Int, moveHashmapList: MutableList<HashMap<String, String>>) : Boolean {
        var gameOver = false
        // 이동할 칸을 선택해주세요.
        OutputView().printMoveTarget()
        val moveInput = InputView().readMoving()

        // compare 로직, 내가 넣은 인풋과 정답 비교.
        val resultMoveHashmap = BridgeGame().move(moveInput, answerMove[trialCount])
        moveHashmapList[trialCount] = resultMoveHashmap
        println("moveHashmapList: $moveHashmapList")
        if (resultMoveHashmap.containsValue("X")) {
            gameOver = true
        }
        showTotalMove(trialCount, moveHashmapList)
        return gameOver
    }

    private fun gameEnd(trialCount: Int, answerMove: List<String>): Boolean {
        if (trialCount == answerMove.size) return true
        return false
    }

    private fun gameOverCheck(resultMoveHashmap: HashMap<String, String>) : Boolean {
        var gameOver = false
        if (resultMoveHashmap.contains("X")) {
            gameOver = true
        }
        return gameOver
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

    private fun finalGame() {
        // 최종 게임 결과
        view.OutputView().printResultFinalGame()
//        val answerMove = BridgeGame().getAnswerMove(bridgeSize)
//        var gameOver = false
//        val moveHashmapList = MutableList(bridgeSize) { it -> HashMap<String, String>() }
//
//
//        totalMovePath = view.OutputView().printMap(trialCount, moveHashmapList)
//        println(totalMovePath[0])
//        println(totalMovePath[1])
    }

    private fun resultGame(trial: Int) {
        // 게임 성공 여부 및 시도 회수
        view.OutputView().printCheckSuccessGame()
        view.OutputView().printNumTotalTrial(trial)
    }

}