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
        return 0
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
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

    companion object {
        const val SIZE_NOT_VALID = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다"
        const val MOVE_NOT_VALID = "[ERROR] 'U' 또는 'D'를 입력해주세요"
        const val END_NOT_VALID = "[ERROR] 'R' 또는 'Q'를 입력해주세요"
    }
}
