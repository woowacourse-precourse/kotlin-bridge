package bridge.resources


// FOR INPUT VIEW
const val INPUT_BRIDGE_LENGTH = "\n다리의 길이를 입력해주세요."
const val INPUT_CHOICE_ROOM = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val INPUT_CHOICE_RESTART = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

// FOR OUTPUT VIEW
const val INPUT_BRIDGE_GAME_START = "다리 건너기 게임을 시작합니다."
const val GAME_END = "\n최종 게임 결과"
const val GAME_RESULT_WIN = "\n게임 성공 여부: 성공"
const val GAME_RESULT_LOSE = "\n게임 성공 여부: 실패"
const val GAME_TRY_COUNT = "총 시도한 횟수: %d"

// FOR SIGN VIEW
const val START_BRACKET = "[ "
const val END_BRACKET = " ]"
const val SEPARATOR = " | "
const val ANSWER = "O"
const val NOT_ANSWER = "X"
const val SPACING = " "

// FOR LOGIC
const val ANSWER_LOCATION = 1
const val MIN_RANGE_LENGTH = 3
const val MAX_RANGE_LENGTH = 20
const val UP = "U"
const val DOWN = "D"
const val RETRY = "R"
const val QUIT = "Q"
const val INPUT_MOVE_SIZE = 1
const val START_LOCATION = 0
const val NEXT_LOCATION = 1
const val START_TRY = 1
const val NEXT_TRY = 1
const val BRIDGE_PADDING = 1
const val SHIFT = 2

// FOR ERROR HANDLING
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_BRIDGE_NULL = ERROR_MESSAGE_PREFIX + "공백이 아닌 숫자를 입력해주세요"
const val ERROR_INPUT_BRIDGE_TYPE = ERROR_MESSAGE_PREFIX + "문자가 아닌 숫자를 입력해주세요."
const val ERROR_INPUT_BRIDGE_RANGE = ERROR_MESSAGE_PREFIX + "3이상 20이하의 숫자를 입력해주세요."
const val ERROR_INPUT_MOVE_NULL = ERROR_MESSAGE_PREFIX + "공백이 아닌 U나 D를 입력해주세요"
const val ERROR_INPUT_MOVE_SIZE = ERROR_MESSAGE_PREFIX + "한 글자만 입력해주세요."
const val ERROR_INPUT_MOVE_DIGIT = ERROR_MESSAGE_PREFIX + "U나 D만 입력해주세요."
const val ERROR_INPUT_RETRY_DIGIT = ERROR_MESSAGE_PREFIX + "Q나 R만 입력해주세요."

