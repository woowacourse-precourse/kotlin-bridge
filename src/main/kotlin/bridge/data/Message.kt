package bridge.data

const val UP = "U"
const val DOWN = "D"
const val RETRY = "R"
const val QUIT = "Q"
const val KEEP = "K"
const val CORRECT = "O"
const val INCORRECT = "X"
const val BLANK = " "
const val LEFT_LADDER = "[ "
const val CENTER_LADDER = " | "
const val RIGHT_LADDER = " ]"
const val NEXT_LINE = "\n"

const val GAME_START = "다리 건너기 게임을 시작합니다."
const val ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
const val ENTER_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val ENTER_GAME_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

const val GAME_RESULT = "최종 게임 결과"
const val GAME_BOOLEAN = "게임 성공 여부: "
const val COUNT_RETRY = "총 시도한 횟수: "

const val SUCCESS = "성공"
const val FAIL = "실패"

const val ERROR_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
const val ERROR_DIGIT = "[ERROR] 숫자만 입력 가능합니다"
const val ERROR_NULL = "[ERROR] 값이 존재하지 않습니다"
const val ERROR_DIRECTION = "[ERROR] 'U' 또는 'D' 만 입력 가능합니다"
const val ERROR_COMMAND = "[ERROR] 'R' 또는 'Q' 만 입력 가능합니다"
