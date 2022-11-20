package bridge.resources

// FOR INPUT VIEW
const val INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
const val INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료: Q)"

// FOR OUTPUT VIEW
const val OUTPUT_BRIDGE_MAP = "[ %s ]"
const val OUTPUT_RESULT_NOTATION = "최종 게임 결과"
const val OUTPUT_RESULT_STATUS = "게임 성공 여부: %s"
const val OUTPUT_RESULT_COUNT_OF_TRY = "총 시도한 횟수: %d"

// FOR ERROR HANDLING
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_NUMBER = ERROR_MESSAGE_PREFIX + "숫자를 입력해주세요."
const val ERROR_INPUT_ALLOWED_KEYS = ERROR_MESSAGE_PREFIX + "올바른 키를 입력해주세요."
const val ERROR_INPUT_NUMBER_IN_RANGE = ERROR_MESSAGE_PREFIX + "범위 내에 값을 입력해주세요."

// FOR BRIDGE GAME LOGIC
const val BRIDGE_MIN_LENGTH = 3
const val BRIDGE_MAX_LENGTH = 20
