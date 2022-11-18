package bridge.domain

import bridge.ui.OutputView
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val outputView = OutputView()

    /**
     * 다리의 길이를 입력받는다.
     */
    private fun readBridgeSize(): Int {
        outputView.printInputBridgeSize()
        return try {
            validateBridgeSize()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            0
        }
    }

    private fun validateBridgeSize(): Int {
        val bridgeSize = Console.readLine().trim()
        require(bridgeSize.all { it.isDigit() }) {
            throw IllegalArgumentException("$PREFIX $DIGIT_EXCEPTION")
        }
        require(bridgeSize.toInt() in 3..20) {
            throw IllegalArgumentException("$PREFIX $RANGE_EXCEPTION")
        }
        return bridgeSize.toInt()
    }

    fun retryReadBridgeSize(): Int {
        var bridgeSize: Int
        do {
            bridgeSize = readBridgeSize()
        } while (bridgeSize == 0)
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    private fun readMoving(): String {
        outputView.printMove()
        return try {
            validateMoving()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            ""
        }
    }

    private fun validateMoving(): String {
        val moving = Console.readLine().trim()
        require((moving == "U") or (moving == "D")) {
            throw IllegalArgumentException("$PREFIX $MOVE_EXCEPTION")
        }
        return moving
    }

    fun retryReadMoving(): String {
        var moving: String
        do {
            moving = readMoving()
        } while (moving == "")
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        private const val PREFIX = "[ERROR]"

        private const val DIGIT_EXCEPTION = "숫자가 아닙니다."
        private const val RANGE_EXCEPTION = "범위가 맞지 않습니다."

        private const val MOVE_EXCEPTION = "U 혹은 D가 아닙니다."
    }
}
