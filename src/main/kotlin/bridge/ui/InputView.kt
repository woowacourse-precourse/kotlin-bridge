package bridge.ui

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    fun readBridgeSize(): Int {
        val size = Console.readLine().toInt()
        return size
    }

    fun readMoving(): String {
        return ""
    }

    fun readGameCommand(): String {
        return ""
    }
}
