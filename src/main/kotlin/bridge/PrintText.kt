package bridge

const val EXCEPTION_WRONG_SIZE = "[ERROR] 3에서 20 사이의 숫자를 입력해 주세요."
const val EXCEPTION_WRONG_MOVE = "[ERROR] U와 D 중 하나를 입력해 주세요."
const val EXCEPTION_WRONG_RESTART = "[ERROR] R과 Q 중 하나를 입력해 주세요."

const val START_MESSAGE = "다리 건너기 게임을 시작합니다."
const val GET_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
const val GET_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val GET_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

const val RESULT_MESSAGE = "최종 게임 결과"
const val RESULT_SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: "
const val RESULT_TRYCOUNT_MESSAGE = "총 시도한 횟수: "

const val UP = "U"
const val DOWN = "D"
const val EMPTY = " "
const val SUCCESS = "O"
const val FAIL = "X"
const val RETRY = "R"
const val QUIT = "Q"

const val MIN_SIZE = 3
const val MAX_SIZE = 20