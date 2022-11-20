package bridge.view

import bridge.INPUT_BRIDGE_LENGTH
import bridge.SELECT_MOVE_DIRECTION
import bridge.START_BRIDGE_GAME
import bridge.ZERO
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

    fun printResult() {}

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


    fun throwException(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }

}
