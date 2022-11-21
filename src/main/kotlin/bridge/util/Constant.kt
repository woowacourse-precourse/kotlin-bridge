package bridge.util

object Constant {

    val GAME_START = "다리 건너기 게임을 시작합니다."
    val BRIDGE_SIZE = "다리의 길이를 입력해주세요."
    val BRIDGE_SELECT = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    val FINAL_RESULT = "최종 게임 결과"
    val GAME_OVER = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    val SUCCESS_OR_FAIL = "게임 성공 여부: "
    val TOTAL_TRY = "총 시도한 횟수: "

    val UP_SIDE = "U"
    val DOWN_SIDE = "D"
    val RETRY = "R"
    val QUIT = "Q"
    val BRIDGE_MIN_SIZE = 3
    val BRIDGE_MAX_SIZE = 20
    val CAN_MOVE_BRIDGE = "UD"
    val GAME_COMMAND = "RQ"

    val ERROR_NUMBER = "[ERROR] 숫자 형태로 입력해주세요."
    val ERROR_RANGE = "[ERROR] 3이상 20이하의 숫자를 입력해주세요."
    val ERROR_SELECT_BRIDGE = "[ERROR] U 또는 D를 입력해주세요."
    val ERROR_COMMAND = "[ERROR] R 또는 Q를 입력해주세요."

    val WIN = "성공"
    val LOSE = "실패"
}