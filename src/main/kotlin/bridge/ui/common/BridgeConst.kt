package bridge.ui.common


const val MIN_BRIDGE_SIZE = 3
const val MAX_BRIDGE_SIZE = 20
const val MOVING_UP_CODE = "U"
const val MOVING_DOWN_CODE = "D"
const val GAME_RESTART_CODE = "R"
const val GAME_QUIT_CODE = "Q"

const val ERROR_MESSAGE_FORMAT = "[ERROR] %s"
const val ERROR_BRIDGE_SIZE_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val ERROR_MOVING_MESSAGE = "위 칸은 U, 아래 칸은 D 문자만 입력 가능합니다."
const val ERROR_GAME_COMMAND_MESSAGE = "게임 재시작은 R, 종료는 Q 문자만 입력 가능합니다."