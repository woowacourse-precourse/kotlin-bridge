package bridge

import bridge.BridgeGame.Companion.BRIDGE_LENGTH_LOWER_INCLUSIVE
import bridge.BridgeGame.Companion.BRIDGE_LENGTH_UPPER_INCLUSIVE
import bridge.BridgeGame.Companion.MOVING_DIRECT_DOWN
import bridge.BridgeGame.Companion.MOVING_DIRECT_UP
import bridge.OutputView.Companion.printErrorMessage
import bridge.exception.BridgeSizeInvalidException
import bridge.exception.MovingInvalidException
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var bridgeSize = readValidateBridgeSize()
        while (bridgeSize == 0) {
            bridgeSize = readValidateBridgeSize()
        }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): Char {
        var moving = readValidateMoving()
        while (moving == ' ') {
            moving = readValidateMoving()
        }
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    private fun readValidateBridgeSize(): Int {
        return try {
            with(Console.readLine().toInt()) {
                if (this in BRIDGE_LENGTH_LOWER_INCLUSIVE..BRIDGE_LENGTH_UPPER_INCLUSIVE) this
                else throw NumberFormatException()
            }
        } catch (e: Exception) {
            printErrorMessage(BridgeSizeInvalidException())
            0
        }
    }

    private fun readValidateMoving(): Char {
        return try {
            with(Console.readLine()) {
                if (this.length == 1 && (this[0] == MOVING_DIRECT_UP || this[0] == MOVING_DIRECT_DOWN)) this[0]
                else throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            printErrorMessage(MovingInvalidException())
            ' '
        }
    }
}
