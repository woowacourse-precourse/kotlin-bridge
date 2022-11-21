package bridge.ui.view

import bridge.ui.validator.InputValidator
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        while (true) {
            val bridgeSize = Console.readLine()

            kotlin.runCatching {
                InputValidator.validateBridgeSize(bridgeSize = bridgeSize)
            }
                .onSuccess { return bridgeSize.toInt() }
                .onFailure { println(it.message) }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            val moving = Console.readLine()

            kotlin.runCatching {
                InputValidator.validateMoving(moving = moving)
            }
                .onSuccess { return moving }
                .onFailure { println(it.message) }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            val command = Console.readLine()

            kotlin.runCatching {
                InputValidator.validateGameCommand(command = command)
            }
                .onSuccess { return command }
                .onFailure { println(it.message) }
        }
    }
}
