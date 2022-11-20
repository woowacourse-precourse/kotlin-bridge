package bridge.util

const val RANGE_START = 3
const val RANGE_END = 20
const val NUMBER_ONE = 1
const val UP = "U"
const val DOWN = "D"
const val RESTART = "R"
const val QUIT = "Q"

// Messages
const val INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
const val SELECT_KEY_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val RESTART_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

// Error
const val ERROR_HEADER = "[ERROR] "
const val ERROR_NUMBER_FORMAT = "다리의 길이는 숫자를 입력해야 합니다."
const val ERROR_BRIDGE_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val ERROR_MOVE_KEY = "(위: U, 아래: D)의 형식으로 입력해야 합니다."
const val ERROR_COMMAND_KEY = "(재시도: R, 종료: Q)의 형식으로 입력해야 합니다."