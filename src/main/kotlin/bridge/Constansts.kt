package bridge

const val BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
const val BRIDGE_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val GAME_RESULT = "최종 게임 결과"
const val GAME_OUTCOME = "게임 성공 여부: "
const val GAME_ATTEMPT_COUNT = "총 시도한 횟수: "

const val UP = "U"
const val DOWN = "D"

const val SUCCESS = "성공"
const val LOSE = "실패"

const val QUIT = "Q"
const val RETRY = "R"

const val PASS = "O"
const val FAIL = "X"

const val OPEN = "["
const val CLOSE = "]"

const val ERROR_BRIDGE_SIZE_STRING = "[ERROR] 다리 길이는 숫자만 입력 가능합니다."
const val ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val ERROR_MOVING = "[ERROR] U, D만 입력 가능합니다."
const val ERROR_GAME_COMMAND = "[ERROR] R, Q만 입력 가능합니다."