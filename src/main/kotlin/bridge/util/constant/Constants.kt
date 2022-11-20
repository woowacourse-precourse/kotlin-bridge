package bridge.util.constant

// messages
const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
const val BRIDGE_LENGTH_QUESTION_MESSAGE = "\n다리의 길이를 입력해주세요."
const val GAME_RETRY_QUESTION_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val DIRECTION_QUESTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val GAME_FINISH_MESSAGE = "최종 게임 결과"
const val GAME_SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: %s"
const val TRIAL_COUNT_MESSAGE = "총 시도한 횟수: %d"

 // bridge map
const val CORRECT_MARK = 'O'
const val WRONG_MARK = 'X'
const val DEFAULT_MARK = ' '
const val BRIDGE_SEPARATOR = " | "
const val BRIDGE_PREFIX = "[ "
const val BRIDGE_POSTFIX =" ]"

// direction
const val UP = "U"
const val DOWN = "D"
const val UP_INDEX = 0
const val DOWN_INDEX = 1

// restart
const val RETRIAL = "R"
const val QUIT = "Q"
const val RETRY_GAME = true
const val FINISH_GAME = false

// result
const val SUCCESS_MESSAGE = "성공"
const val FAIL_MESSAGE = "실패"

// round
const val BASE_ROUND = 0

// count
const val INITIAL_TRY_COUNT = 1

// error
private const val ERROR_PREFIX = "[ERROR] "
const val BRIDGE_LENGTH_NOT_NUMBER_EXCEPTION_MESSAGE = ERROR_PREFIX + "입력한 값이 숫자가 아닙니다."
const val BRIDGE_LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE = ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val INVALID_DIRECTION_EXCEPTION_MESSAGE = ERROR_PREFIX + "이동 방향으로 U 또는 D를 입력해야 합니다."
const val INVALID_RETRIAL_EXCEPTION_MESSAGE = ERROR_PREFIX + "재시도 여부는 R 또는 Q를 입력해야 합니다."