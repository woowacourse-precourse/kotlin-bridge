package bridge.view

import bridge.Constans.ERROR
import bridge.Constans.FINAL_GAME_RESULT
import bridge.Constans.INPUT_BRIDGE_LENGTH
import bridge.Constans.INPUT_RETRY_OR_QUIT
import bridge.Constans.NULL
import bridge.Constans.SELECT_MOVE_DIRECTION
import bridge.Constans.START_BRIDGE_GAME
import bridge.Constans.TOTAL_TRY_COUNT
import bridge.Constans.WHETHER_SUCCESS_OR_NOT
import bridge.Constans.ZERO
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
object OutputView {
    fun printMap(progress: Array<Array<String>>, position: Int) {
        progress.map { oneLine ->
            oneLine.mapIndexed { index, str ->
                handleWhenIsNotNull(str, index, position)
            }
            println()
        }
        println()
    }

    private fun handleWhenIsNotNull(str: String, index: Int, size: Int) {
        if (str != NULL) {
            printOneLineOfMatrix(str, index, size)
        }
    }

    private fun printOneLineOfMatrix(str: String, index: Int, size: Int) {
        if (index == ZERO) {
            print("[ $str ")
            if (size == ZERO) print("]")
        } else {
            print("| $str ")
            if (size == index) print("]")
        }
    }

    fun printResult(arr: Array<Array<String>>, pos: Int) {
        printMap(arr, pos)
    }

    fun startGame() {
        println(START_BRIDGE_GAME)
        println()
    }

    fun inputLength() {
        println(INPUT_BRIDGE_LENGTH)
    }

    fun selectMove() {
        println(SELECT_MOVE_DIRECTION)
    }

    fun retryOrQuit() {
        println(INPUT_RETRY_OR_QUIT)
    }

    fun finalResult() {
        println(FINAL_GAME_RESULT)
    }

    fun isSuccess(resultText: String) {
        println("$WHETHER_SUCCESS_OR_NOT $resultText")
    }

    fun totalTryCount(tryCnt: Int) {
        println("$TOTAL_TRY_COUNT $tryCnt")
    }

    fun throwIllegalException(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }

    fun throwNumberException(errorMessage: String) {
        throw NumberFormatException(errorMessage)
    }

    fun printError(e: IllegalArgumentException) {
        println("$ERROR ${e.message}\n")
    }

}
