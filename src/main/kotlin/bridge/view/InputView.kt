package bridge.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {

    fun readBridgeSize(): String {
        println(INPUT_BRIDGE_LENGTH)

        return readLine().trim()
    }

    fun readMoving(): String {
        println(INPUT_MOVEMENT)

        return readLine().trim()
    }

    fun readGameCommand(): String {
        println(INPUT_RESTART)

        return readLine().trim()
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
