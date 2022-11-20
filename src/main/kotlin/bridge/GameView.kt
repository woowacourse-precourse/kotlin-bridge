package bridge

import bridge.BridgeGame.Companion.BRIDGE_LENGTH_LOWER_INCLUSIVE
import bridge.BridgeGame.Companion.BRIDGE_LENGTH_UPPER_INCLUSIVE
import bridge.BridgeGame.Companion.MOVING_DIRECT_DOWN
import bridge.BridgeGame.Companion.MOVING_DIRECT_UP

class GameView(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    companion object {
        const val ERROR_MESSAGE_PREFIX = "[ERROR] "
        const val ERROR_MESSAGE_INPUT_BRIDGE_LENGTH =
            "다리 길이는 ${BRIDGE_LENGTH_LOWER_INCLUSIVE}부터 $BRIDGE_LENGTH_UPPER_INCLUSIVE 사이의 숫자여야 합니다."
        const val ERROR_MESSAGE_INPUT_MOVING = "$MOVING_DIRECT_UP 혹은 ${MOVING_DIRECT_DOWN}을 입력해 주세요."
        const val ERROR_UNKNOWN = "알 수 없는 에러"
    }
}