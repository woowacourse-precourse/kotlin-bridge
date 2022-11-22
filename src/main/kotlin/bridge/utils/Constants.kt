package bridge.utils

object Constants {
    /**
     * 게임 진행 메시지
     */
    const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n"
    const val GAME_INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
    const val GAME_INPUT_MOVE_LANE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val GAME_INPUT_GAME_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val GAME_FINISH_MESSAGE = "최종 게임 결과"
    const val GAME_SUCCESS_OR_FAIL_MESSAGE = "\n게임 성공 여부: "
    const val GAME_TRIAL_COUNT_MESSAGE = "총 시도한 횟수: "

    /**
     * 에러 메시지
     */
    const val ERROR_BRIDGE_SIZE_NOT_IN_3_AND_20_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
    const val ERROR_NOT_INT_TYPE_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다."
    const val ERROR_NOT_U_OR_D_MESSAGE = "[ERROR] 이동할 칸으로 U 또는 D 를 입력해야 합니다."
    const val ERROR_NOT_R_OR_Q_MESSAGE = "[ERROR] 재시도 여부로 R 또는 Q 를 입력해야 합니다."

    /**
     * 게임 심볼
     */
    const val UP_SYMBOL = "U"
    const val DOWN_SYMBOL = "D"
    const val RETRIAL_SYMBOL = "R"
    const val QUIT_SYMBOL = "Q"
    const val SUCCESS_SYMBOL = " O "
    const val FAIL_SYMBOL = " X "
    const val EMPTY_SYMBOL = "   "
}