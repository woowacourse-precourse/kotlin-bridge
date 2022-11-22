package bridge

const val NOT_INITIALIZED = "[ N ]"
const val SUCCESSIVE_PARENTHESIS = "]["
const val CONNECT_PARENTHESIS = "|"

const val AVAILABLE_PATH = "O"
const val UNAVAILABLE_PATH = "X"

const val RETRY_INPUT = "R"
const val QUIT_INPUT = "Q"

/**
 * 내가 커스텀한 경로의 형태를 출력 형식에 맞추기 위해서 FORMATTING 한다.
 */
fun String.formattingMap() =
    this.replace(NOT_INITIALIZED, "")
        .replace(SUCCESSIVE_PARENTHESIS, CONNECT_PARENTHESIS)


const val ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.\n"
const val ASK_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n"
const val ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"


const val GAME_START = "다리 건너기 게임을 시작합니다."
const val GAME_RESULT = "최종 게임 결과"
const val GAME_RESULT_FLAG = "게임 성공 여부: %s"
const val THE_NUMBER_OF_TRY = "총 시도한 횟수: %d"