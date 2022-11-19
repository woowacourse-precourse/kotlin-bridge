package utils

object Messages {
    const val START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.\n"
    const val INPUT_BRIDGE_LEN = "다리의 길이를 입력해주세요."
    const val MOVE_TARGET = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val ASK_GAME_REPEAT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val RESULT_FINAL_GAME = "최종 게임 결과"
    const val CHECK_SUCCESS_GAME = "게임 성공 여부: "
    const val NUM_TOTAL_TRIAL = "총 시도한 횟수: "

    // 에러
    const val ERROR_PREFIX = "[ERROR] "
    const val ERROR_BRIDGE_SIZE = "올바른 다리 길이를 입력해주세요."
}