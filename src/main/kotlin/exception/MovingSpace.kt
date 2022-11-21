package exception

import bridge.InputView

class MovingSpace() {
    private val inputView = InputView()
    private var space = ""

    fun verify() {
        while (true) {
            try {
                space = inputView.readMoving()
                checkException(space)
            } catch (e: IllegalArgumentException) {
                continue
            }
            break
        }
    }

    fun getInput() = space

    fun checkException(space: String) {
        require(space == "U" || space == "D") {
            println("[ERROR] 이동할 칸은 U(위)나 D(아래)여야 합니다. 다시 입력해주세요.")
        }
    }
}