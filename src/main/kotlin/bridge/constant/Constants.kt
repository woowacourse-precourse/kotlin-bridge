package bridge.constant

const val GAME_START_MSG = "다리 건너기 게임을 시작합니다.\n"
const val REQUEST_INPUT_BRIDGE_SIZE_MSG = "다리의 길이를 입력해주세요."
const val REQUEST_INPUT_MOVE_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val REQUEST_INPUT_QUIT_OR_RETRY_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val GAME_RESULT = "최종 게임 결과"
const val SUCCESS_RESULT_MSG = "게임 성공 여부: "
const val ATTEMPTS_NUM_RESULT_MSG = "총 시도한 횟수: "
const val GAME_SUCCESS = "성공"
const val GAME_FAIL = "실패"
const val UP_SIDE = "U"
const val DOWN_SIDE = "D"
const val RETRY_GAME = "R"
const val QUIT_GAME = "Q"

const val WRONG = 2
const val CORRECT = 1
const val END = 3

const val ERROR_INPUT_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. 다시 입력해주세요."
const val ERROR_INPUT_PLAYER_MOVE = "[ERROR] Player의 움직임은 U/D 중 하나만 가능합니다. 둘 중 하나의 값을 입력해주세요."
const val ERROR_INPUT_COMMAND = "[ERROR] R(게임재시작)과 Q(게임 종료) 중 하나의 값을 입력해주세요."