package bridge.view

import bridge.common.toIntOrThrow
import bridge.constants.ErrorMessages
import bridge.data.Bridge
import camp.nextstep.edu.missionutils.Console.readLine

private typealias InputError = ErrorMessages.InputViewEnum

class InputView {

    fun readBridgeSize(): Int {
        val bridgeSize = readLine().toIntOrThrow()

        require(bridgeSize in Bridge.SizeRange) {
            InputError.OutOfBridgeSize
        }

        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val bridgeType = readLine()

        require(Bridge.Type.contains(bridgeType)) {
            InputError.InvalidBridgeType
        }

        return bridgeType
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
