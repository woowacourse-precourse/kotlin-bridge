package bridge.ui

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    fun readBridgeSize(): Int {
        while (true) {
            val size = Console.readLine()
            kotlin.runCatching { InputChecker().except(size) }
                .onSuccess { return size.toInt() }
                .onFailure { println(it.message) }
        }
    }

    fun readMoving(): String {
        return ""
    }

    fun readGameCommand(): String {
        return ""
    }

}
