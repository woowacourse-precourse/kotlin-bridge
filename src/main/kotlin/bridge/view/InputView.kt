package bridge.view

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return 0
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

    companion object {
        const val MOVE_UP = "U"
        const val MOVE_DOWN = "D"
        const val GAME_RESTART = "R"
        const val GAME_END = "Q"

        const val INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
        const val INPUT_MOVEMENT = "이동할 칸을 선택해주세요. (위: $MOVE_UP, 아래: $MOVE_DOWN)"
        const val INPUT_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: $GAME_RESTART, 종료: $GAME_END)"
    }
}
