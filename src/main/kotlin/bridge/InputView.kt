package bridge

import camp.nextstep.edu.missionutils.Console as cs

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var validFlag = true
        var size = 0

        while (validFlag) {
            size = getBridgeSize()
            if (size in 3..20) {
                validFlag = false
            }
        }
        return size
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var validFlag = true
        var moveChoice = ""
        while (validFlag) {
            println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
            moveChoice = cs.readLine()
            validFlag = needToAskMoveAgain(moveChoice)
        }
        return moveChoice
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    private fun getBridgeSize(): Int {
        println()
        println("다리의 길이를 입력해주세요.")
        val bridgeSize = cs.readLine()

        val size = isSizeNumeric(bridgeSize)
        if (size > 20 || size < 3) {
            println(SIZE_NOT_VALID)
            return 0
        }
        return size
    }

    private fun isSizeNumeric(inputValue: String): Int {
        try {
            return inputValue.toInt()
        } catch (exception: IllegalArgumentException) {
            println(SIZE_NOT_VALID)
        }

        return 0
    }
    private fun needToAskMoveAgain(moveChoice: String): Boolean {
        if (moveChoice == "U" || moveChoice == "D") {
            return false
        }
        println(MOVE_NOT_VALID)
        return true
    }

    private fun needToAskCommandAgain(moveChoice: String): Boolean {
        if (moveChoice == "R" || moveChoice == "Q") {
            return false
        }
        println(END_NOT_VALID)
        return true
    }

    companion object {
        const val SIZE_NOT_VALID = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다"
        const val MOVE_NOT_VALID = "[ERROR] 'U' 또는 'D'를 입력해주세요"
        const val END_NOT_VALID = "[ERROR] 'R' 또는 'Q'를 입력해주세요"
    }
}
