package bridge.util

// Message
const val START_GAME_MASSAGE = "다리 건너기 게임을 시작합니다."
const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
const val SELECT_MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val SELECT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과"
const val GAME_WHETHER_MESSAGE = "게임 성공 여부: "
const val TOTAL_TRIAL_MESSAGE = "총 시도한 횟수: "

// ERROR
const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다."
const val ERROR_INVALID_MOVE_MESSAGE = "[ERROR] U와 D만 이동 입력이 가능합니다."
const val ERROR_INVALID_COMMAND_MESSAGE = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다"
const val ERROR_INVALID_INPUT_MESSAGE = "[ERROR] 잘못된 입력 입니다."
/*Expression*/

// bridge
const val UP_BRIDGE = 0
const val DOWN_BRIDGE = 1
const val TWO_BRIDGE = 2
const val MIN_BRIDGE_SIZE = 3
const val MAX_BRIDGE_SIZE = 20

// number
const val UP_INT_NUMBER_ONE = 1
const val DOWN_INT_NUMBER_ZERO = 0

// command
const val UP_DIRECTION = "U"
const val DOWN_DIRECTION = "D"
const val QUIT_COMMAND = "Q"
const val RESTART_COMMAND = "R"

// pass
const val PASS_POSSIBLE_EXPRESSION = "O"
const val PASS_IMPOSSIBLE_EXPRESSION = "X"

// sign
const val EMPTY_EXPRESSION = ""
const val OPEN_BRACKET ="[ "
const val CLOSE_BRACKET =" ]\n"
const val VERTICAL_LINE = " | "