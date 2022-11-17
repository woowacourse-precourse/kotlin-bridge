package bridge.util

// messages
const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
const val BRIDGE_LENGTH_QUESTION_MESSAGE = "다리의 길이를 입력해주세요."
const val GAME_RETRY_QUESTION_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val DIRECTION_QUESTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val GAME_SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: %s"
const val TRIAL_COUNT_MESSAGE = "총 시도한 횟수: %d"

// result
const val SUCCESS_MESSAGE = "성공"
const val FAIL_MESSAGE = "실패"

// error
private const val ERROR_PREFIX = "[ERROR] "
const val BRIDGE_LENGTH_NOT_NUMBER_EXCEPTION_MESSAGE = ERROR_PREFIX + "입력한 값이 숫자가 아닙니다."
const val BRIDGE_LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE = ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다."
