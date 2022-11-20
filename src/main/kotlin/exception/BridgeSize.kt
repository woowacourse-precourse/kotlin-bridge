package exception

import bridge.InputView

class BridgeSize(private val inputView: InputView) {
    private var size = 0

    fun verify() {
        while (true) {
            try {
                size = inputView.readBridgeSize()
                checkException()
            } catch (e: IllegalArgumentException) {
                continue
            }
            break
        }
    }

    fun getInput() = size

    private fun checkException() {
        require(size in 3..20) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. 다시 입력해주세요.")
        }
    }
}