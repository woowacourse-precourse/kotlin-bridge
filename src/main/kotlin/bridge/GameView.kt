package bridge

import bridge.BridgeGame.Companion.BRIDGE_LENGTH_LOWER_INCLUSIVE
import bridge.BridgeGame.Companion.BRIDGE_LENGTH_UPPER_INCLUSIVE
import bridge.BridgeGame.Companion.GAME_COMMAND_QUIT
import bridge.BridgeGame.Companion.GAME_COMMAND_RESTART
import bridge.BridgeGame.Companion.MOVING_DIRECT_DOWN
import bridge.BridgeGame.Companion.MOVING_DIRECT_UP

class GameView(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    init {
        outputView.printGameStart()
    }

    fun readBridgeSize() {
        outputView.printInputNotice(InputType.BRIDGE_SIZE)
        inputView.readBridgeSize()
    }

    fun readMoving() {
        outputView.printInputNotice(InputType.MOVING)
        inputView.readMoving()
    }

    fun readGameCommand() {
        outputView.printInputNotice(InputType.GAME_COMMAND)
        inputView.readGameCommand()
    }

    companion object {
        const val ERROR_MESSAGE_PREFIX = "[ERROR] "
        const val ERROR_MESSAGE_INPUT_BRIDGE_LENGTH =
            "다리 길이는 ${BRIDGE_LENGTH_LOWER_INCLUSIVE}부터 $BRIDGE_LENGTH_UPPER_INCLUSIVE 사이의 숫자여야 합니다."
        const val ERROR_MESSAGE_INPUT_MOVING = "$MOVING_DIRECT_UP 혹은 ${MOVING_DIRECT_DOWN}을 입력해 주세요."
        const val ERROR_MESSAGE_INPUT_GAME_COMMAND = "$GAME_COMMAND_RESTART 혹은 ${GAME_COMMAND_QUIT}를 입력해 주세요."
        const val ERROR_MESSAGE_UNKNOWN = "알 수 없는 에러"

        const val MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다."
    }
}

enum class InputType(val message: String) {
    BRIDGE_SIZE(
        "다리의 길이를 입력해 주세요."
    ),
    MOVING(
        "이동할 칸을 선택해 주세요. (위: $MOVING_DIRECT_UP, 아래: $MOVING_DIRECT_DOWN)"
    ),
    GAME_COMMAND(
        "게임을 다시 시도할지 여부를 입력해 주세요. (재시도: ${GAME_COMMAND_RESTART}, 종료: $GAME_COMMAND_QUIT)"
    )
}