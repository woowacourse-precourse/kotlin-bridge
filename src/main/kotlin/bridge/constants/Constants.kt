package bridge.constants

const val START_MESSAGE = "다리 건너기 게임을 시작합니다.\n"
const val BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
const val MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val RESULT_MESSAGE = "최종 게임 결과"
const val RESULT_SUCCESS_OR_FAIL = "게임 성공 여부: "
const val RESULT_TRY_COUNT = "총 시도한 횟수: "
const val ENTER_AGAIN = "다시 입력해주세요."

enum class MapPrint(val symbol: String) {
    START("[ "),
    END(" ]"),
    SEPARATOR(" | "),
}

enum class BridgeSize(val size: Int) {
    START(3), END(20)
}

const val CORRECT_ANSWER = "O"
const val WRONG_ANSWER = "X"

const val SUCCESS = "성공"
const val FAIL = "실패"

enum class Error(val message: String) {
    BRIDGE_INPUT("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE_INPUT("U 또는 D 로 입력해주세요."),
    RETRY_OR_QUIT("R 또는 Q 로 입력해주세요.")
}
