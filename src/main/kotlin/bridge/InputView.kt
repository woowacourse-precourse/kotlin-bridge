package bridge

import bridge.exceptions.InvalidRequestException
import bridge.strings.BridgeGameErrorMessages
import bridge.strings.InputViewErrorMessages
import camp.nextstep.edu.missionutils.Console
import kotlin.reflect.KFunction0

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다양한 InputView가 있다고 가정한다.
     * 어떤 InputView로 사용자 입력을 처리할지 결정한다.
     */
    fun readLineAbout(requestType: RequestType): String {
        return when (requestType) {
            RequestType.INIT -> readBridgeSize()
            RequestType.MOVE -> readMoving()
            RequestType.RETRY -> readRetryCommand()
            else -> throw InvalidRequestException(InputViewErrorMessages.INVALID_INPUT.message)
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    private fun readBridgeSize(): String {
        return Console.readLine()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    private fun readMoving(): String {
        return Console.readLine()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    private fun readRetryCommand(): String {
        return Console.readLine()
    }
}
