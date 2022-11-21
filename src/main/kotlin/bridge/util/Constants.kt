package bridge.util

// Message
const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
const val SELECT_MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val SELECT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과"
const val GAME_FAILURE_MESSAGE = "게임 성공 여부: 실패"
const val GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공"

// ERROR
const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다."
const val ERROR_INVALID_MOVE_MESSAGE = "[ERROR] U와 D만 이동 입력이 가능합니다."
const val ERROR_INVALID_COMMAND_MESSAGE = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다"

// Expression
const val UP_INT_NUMBER_ONE = 1
const val DOWN_INT_NUMBER_ZERO = 0
const val UP_DIRECTION = "U"
const val DOWN_DIRECTION = "D"
const val QUIT_COMMAND = "Q"
const val RESTART_COMMAND = "R"