package util

object BridgeMessage {
    // InputView
    const val READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
    const val READ_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val READ_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val READ_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 3이상 20이하 숫자를 입력해주세요."
    const val READ_MOVE_ERROR_MESSAGE = "[ERROR] \"U\" 나 \"D\"를 입력해주세요."
    const val READ_COMMAND_ERROR_MESSAGE = "[ERROR] \"R\" 이나 \"Q\"를 입력해주세요."

    // OutputView
    const val GAME_START_NOTIFICATION = "다리 건너기 게임을 시작합니다.\n"
    const val SUCCESS = "성공"
    const val FAIL = "실패"
    const val FAIL_ENGLISH = "FAIL"
    const val FINAL_GAME_RESULT = "최종 게임 결과"
    const val IS_SUCCESS = "게임 성공 여부:"
    const val TOTAL_ATTEMPT = "총 시도한 횟수:"
    const val LEFT_SQUARE_BRACKETS = "["
    const val RIGHT_SQUARE_BRACKETS = "]"
}
