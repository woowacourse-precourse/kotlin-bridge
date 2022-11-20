package bridge.view

import bridge.*
import java.lang.IllegalArgumentException

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
        if (str != "") {
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

    fun throwException(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }

    fun printError(e: Exception){
        println("$ERROR ${e.message}\n")
    }

}
