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
        println("다리 건너기 게임을 시작합니다.\n")
        return try {
            println("다리의 길이를 입력해주세요.")
            Console.readLine()!!.bridgeSizeInputTypeException()
        } catch (e: IllegalArgumentException) {
            println(Constant.ERROR_MESSAGE)
            readBridgeSize()
        }
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
