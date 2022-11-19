package controller

import model.BridgeGame
import view.InputView
import view.OutputView
import kotlin.reflect.typeOf

class Controller {
    fun run() {
        val answerMove = startGame()
        var retry = true
        var gameResult = mutableListOf<Int>()
        var resultGame = "실패"
        var countRetry = 0
        while (retry) {
            gameResult = totalGame(answerMove)
            if (gameResult[0] == 1) {
                retry = BridgeGame().retry()
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
        // 다리 건너기 게임을 시작합니다.
        OutputView().printGameStart()

        // 다리의 길이를 입력해주세요.
        OutputView().printBridgeLen()
        val bridgeSize = InputView().readBridgeSize()
        val answerMove = BridgeGame().getAnswerMove(bridgeSize)
        println()
        return answerMove
    }

    private fun totalGame(answerMove: List<String>): MutableList<Int> {
        var trialCount = 0
        var gameOver = mutableListOf<Int>(0, 0, 0)
//        val moveHashmapList = MutableList(answerMove.size) { it -> HashMap<String, String>() }
        val moveHashmapList = mutableListOf<HashMap<String, String>>()
        while (true) {
            gameOver = singleGame(answerMove, trialCount, moveHashmapList)
            trialCount += 1
            gameOver[1] = trialCount

            println("totalGame_gameOver[0]: ${gameOver[0]}")
            if (gameOver[0] == 1) {
                return gameOver
            }
            if (gameOver[2] == answerMove.size) {
                return gameOver
            }
        }
    }

    private fun singleGame(
        answerMove: List<String>,
        trialCount: Int,
        moveHashmapList: MutableList<HashMap<String, String>>
    ): MutableList<Int> {
        val gameOver = mutableListOf<Int>(0, 0, 0)
        // 이동할 칸을 선택해주세요.
        OutputView().printMoveTarget()
        val moveInput = InputView().readMoving().trim()

        // compare 로직, 내가 넣은 인풋과 정답 비교.
        val resultMoveHashmap = BridgeGame().move(moveInput, answerMove[trialCount])
        moveHashmapList.add(trialCount, resultMoveHashmap)
        gameOver[2] = moveHashmapList.size
        println("moveHashmapList: $moveHashmapList")
        if (resultMoveHashmap.containsValue("X")) {
            gameOver[0] = 1
        }
//        gameOver[1] = trialCount
        showTotalMove(trialCount, moveHashmapList)
        println("singleGameGameOver[0]: ${gameOver[0]}")
        return gameOver
    }

    private fun gameEnd(trialCount: Int, answerMove: List<String>): Boolean {
        if (trialCount == answerMove.size) return true
        return false
    }

    private fun gameOverCheck(resultMoveHashmap: HashMap<String, String>): Boolean {
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

    private fun finalGame(resultGame: String) {
        // 최종 게임 결과
        OutputView().printResultFinalGame()
        OutputView().printCheckSuccessGame(resultGame)
    }

    private fun resultGame(trial: Int) {
        // 게임 성공 여부 및 시도 회수
        view.OutputView().printNumTotalTrial(trial)
    }

}