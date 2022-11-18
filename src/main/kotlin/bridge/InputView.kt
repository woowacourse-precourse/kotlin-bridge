package bridge

import constant.Message

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var input: String?
        do {
            println(Message.BRIDGE_SIZE_INPUT.message)
            input = readLine()
            val retry = BridgeSizeChecker(input).checkAll()
            println()
        } while (retry)
        return input?.toInt() ?: 0
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var input: String?
        do {
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            input = readLine()
            val retry = MovingChecker(input).checkAll()
            if (retry) println()
        } while (retry)
        return input ?: ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
