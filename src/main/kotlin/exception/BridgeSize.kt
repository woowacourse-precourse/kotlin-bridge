package exception

import bridge.InputView

class BridgeSize() {
    private val inputView = InputView()
    private var size = 0

    fun verify() {
        while (true) {
            try {
                size = inputView.readBridgeSize()
                checkNumberFormatException(size)
                checkIllegalArgumentException(size)
            } catch (e: NumberFormatException) {
                println("[ERROR] 다리 길이는 숫자만 입력 가능합니다. 다시 입력해주세요.")
                continue
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. 다시 입력해주세요.")
                continue
            }
            break
        }
    }

    fun getInput() = size

    fun checkNumberFormatException(size: Int) {
        val regex = "^[0-9]*\$".toRegex()

        if (!size.toString().matches(regex)) {
            throw NumberFormatException()
        }
    }

    fun checkIllegalArgumentException(size: Int) {
        if (size !in 3..20) {
            throw IllegalArgumentException()
        }
    }
}