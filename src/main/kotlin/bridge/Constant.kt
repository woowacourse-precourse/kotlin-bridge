package bridge

object Constant {

    const val UP = "U"
    const val DOWN = "D"
    const val EMPTY = " "
    const val ANSWER = "O"
    const val FALL = "X"
    const val REPLAY = "R"
    const val QUIT = "Q"

    const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
    const val SELECT_MOVE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val SELECT_RESTART_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
    const val GAME_OVER_MESSAGE = "\n최종 게임 결과"
    const val GAME_SUCCESS_MESSAGE = "\n게임 성공 여부: 성공"
    const val GAME_FAILED_MESSAGE = "\n게임 성공 여부: 실패"
    const val TOTAL_ATTEMPTS_MESSAGE = "총 시도한 횟수 "

    const val ERROR_MESSAGE = "[ERROR] 잘못입력하셨습니다."
    const val INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력한 값이 숫자가 아닙니다."
    const val INPUT_RANGE_ERROR_MESSAGE = "[ERROR] 입력한 값이 3이상 20이하에 숫자가 아닙니다."
    const val MOVING_INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력한 값이 U와 D가 아닙니다."
    const val GAME_COMMAND_INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력한 값이 R과 Q가 아닙니다."

}