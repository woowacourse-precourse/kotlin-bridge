package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val bridgeSize = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("다리 길이는 숫자여야 합니다.")
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw IllegalArgumentException("다리 길이는 3 이상 20 이하의 숫자여야 합니다.")
        }
        return bridgeSize
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
}
