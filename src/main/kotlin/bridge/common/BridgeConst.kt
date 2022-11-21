package bridge.common

/** 위, 아래 2개의 다리 **/
const val BRIDGE_ROW_SIZE = 2

const val MIN_BRIDGE_SIZE = 3
const val MAX_BRIDGE_SIZE = 20

const val BRIDGE_NUMBER_UP = 1
const val BRIDGE_NUMBER_DOWN = 0

const val MOVING_UP_CODE = "U"
const val MOVING_DOWN_CODE = "D"
const val GAME_RESTART_CODE = "R"
const val GAME_QUIT_CODE = "Q"


const val CROSSED_SUCCESS_RESULT = "O"
const val CROSSED_FAIL_RESULT = "X"

const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n"
const val INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.\n"
const val INPUT_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n"
const val INPUT_GAME_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"

const val FINAL_GAME_RESULT_MESSAGE = "\n최종 게임 결과\n"
const val GAME_SUCCESSFUL_FORMAT = "\n게임 성공 여부: %s\n"
const val GAME_TRY_NUMBER_FORMAT = "총 시도한 횟수: %d\n"
const val FINAL_SUCCESS_RESULT = "성공"
const val FINAL_FAIL_RESULT = "실패"

const val ERROR_MESSAGE_FORMAT = "[ERROR] %s\n"
const val ERROR_BRIDGE_SIZE_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val ERROR_MOVING_MESSAGE = "위 칸은 U, 아래 칸은 D 문자만 입력 가능합니다."
const val ERROR_GAME_COMMAND_MESSAGE = "게임 재시작은 R, 종료는 Q 문자만 입력 가능합니다."