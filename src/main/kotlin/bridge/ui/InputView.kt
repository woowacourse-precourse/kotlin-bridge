package bridge.ui

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readBridgeSize(): Int {
        while (true) {
            val size = Console.readLine()
            kotlin.runCatching { InputChecker().checkBridgeLength(size) }
                .onSuccess { return size.toInt() }
                .onFailure { OutputView().printErrorMessage(it.message) }
        }
    }

    fun readMoving(): String {
        while (true) {
            val upAndDown = Console.readLine()
            kotlin.runCatching { InputChecker().checkDirection(upAndDown) }
                .onSuccess { return upAndDown }
                .onFailure { OutputView().printErrorMessage(it.message) }
        }
    }

    fun readGameCommand(): String {
        while (true) {
            val command = Console.readLine()
            kotlin.runCatching { InputChecker().checkUserCommand(command) }
                .onSuccess { return command }
                .onFailure { OutputView().printErrorMessage(it.message) }
        }
    }
}
