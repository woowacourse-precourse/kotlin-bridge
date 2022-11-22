package bridge.resources

// FOR INPUT VIEW
const val INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
const val INPUT_NEXT_MOVING_POSITION = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val INPUT_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

// FOR OUTPUT VIEW
const val OUTPUT_START_GAME = "다리 건너기 게임을 시작합니다."
const val OUTPUT_RESULT_GAME_TITLE= "최종 게임 결과"
const val OUTPUT_RESULT_GAME_IS_SUCCESS = "게임 성공 여부: %s"
const val OUTPUT_RESULT_GAME_RETRY_COUNT = "총 시도한 횟수: %d"
const val OUTPUT_RESULT_GAME_SUCCESS = "성공"
const val OUTPUT_RESULT_GAME_FAIL = "실패"

// FOR ERROR HANDLING
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_VALUE_NEXT_MOVING = ERROR_MESSAGE_PREFIX + "U(위 칸) 또는 D(아래 칸)만 입력 가능합니다."
const val ERROR_INPUT_VALUE_RETRY_OR_QUIT = ERROR_MESSAGE_PREFIX + "R(재시도) 또는 Q(종료)만 입력 가능합니다."
const val ERROR_INPUT_VALUE_BRIDGE_LENGTH = ERROR_MESSAGE_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val ERROR_INPUT_VALUE_NUMBER_ONLY = ERROR_MESSAGE_PREFIX + "정수만 입력해주세요."
const val ERROR_INPUT_VALUE_0_1_ONLY = ERROR_MESSAGE_PREFIX + "0또는 1만 다리 생성에 이용 가능합니다."

// FOR BRIDGE LOGIC
const val BRIDGE_LENGTH_MIN = 3
const val BRIDGE_LENGTH_MAX = 20
const val BRIDGE_TOP_LINE_CHAR = "U"
const val BRIDGE_BOTTOM_LINE_CHAR = "D"
const val BRIDGE_SELECT_POSITION_PERMIT_CHAR = "O"
const val BRIDGE_SELECT_POSITION_DENIED_CHAR = "X"
const val BRIDGE_RETRY = "R"
const val BRIDGE_QUIT = "Q"
const val BRIDGE_DELIMITER_BETWEEN_MOVING = "|"
const val BRIDGE_ROUTE_START_SYMBOL = "["
const val BRIDGE_ROUTE_END_SYMBOL = "]"