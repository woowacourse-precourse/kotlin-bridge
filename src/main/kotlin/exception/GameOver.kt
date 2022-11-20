package exception

import bridge.InputView

class GameOver(private val inputView: InputView, private var retryOrQuit: String) {
    fun verify() {
        while (true) {
            try {
                retryOrQuit = inputView.readGameCommand()
                checkException()
            } catch (e: IllegalStateException) {
                continue
            }
            break
        }
    }

    fun getInput() = retryOrQuit

    private fun checkException() {
        check(retryOrQuit == "R" || retryOrQuit == "Q") {
            println("[ERROR] 게임을 재시작 및 종료할 수 없습니다. R(재시작)이나 Q(종료)를 입력해주세요.")
        }
    }
}